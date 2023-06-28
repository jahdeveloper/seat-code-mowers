package com.seatcode.mowerchallenge.services;

import com.seatcode.mowerchallenge.models.GridBean;
import com.seatcode.mowerchallenge.models.MowerBean;
import com.seatcode.mowerchallenge.models.Pair;
import com.seatcode.mowerchallenge.services.impl.MowerControllerServiceImpl;
import com.seatcode.mowerchallenge.utils.Parser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static com.seatcode.mowerchallenge.services.TestUtils.*;
import static com.seatcode.mowerchallenge.utils.Constants.MOVEMENT_ACTION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Jose Hidalgo
 * Java Class that test the application controller
 */
@RunWith(MockitoJUnitRunner.class)
public class ApplicationControllerImplTest {

    @InjectMocks
    private ApplicationControllerImplTest applicationControllerImplTest;


    @Test
    public void createGrid() {
        GridBean gridBean = Parser.createGrid(NORMAL_GRID_DIMENSION);
        assertNotNull(gridBean);
        assertNotNull(gridBean.getySize());
        assertEquals(5, gridBean.getxSize());
        assertEquals(5, gridBean.getySize());
    }

    @Test
    public void createMowerBean() {
        MowerBean mowerBean = Parser.createMowerBean(NORMAL_MOWER_POSITION);
        assertNotNull(mowerBean);
        assertNotNull(mowerBean.getPositionX());
        assertNotNull(mowerBean.getPositionY());
        assertNotNull(mowerBean.getDirection());
    }

    @Test
    public void createMovementsList() {
        ArrayList<String> movementList = Parser.createMovementsList(MOWER_MOVEMENTS);
        Assert.assertTrue(!movementList.isEmpty());
    }

    @Test
    public void checkCollisions() {
        MowerControllerServiceImpl mowerControllerService = new MowerControllerServiceImpl();
        GridBean grid = Parser.createGrid(NORMAL_GRID_DIMENSION);
        MowerBean mowerBean = Parser.createMowerBean(NORMAL_MOWER_POSITION);
        Set<Pair<Integer, Integer>> mowerList = new HashSet<>();
        boolean mowerCollisionStatus = mowerControllerService.checkMowerCollision(mowerList, mowerBean);
        boolean mowerOnGridStatus = mowerControllerService.checkMowerOnGrid(grid, mowerBean);

        Assert.assertEquals(true, mowerCollisionStatus);
        Assert.assertEquals(true, mowerOnGridStatus);
    }

    @Test
    public void checkMowerMovements() {
        MowerControllerServiceImpl mowerControllerService = new MowerControllerServiceImpl();
        GridBean grid = Parser.createGrid(NORMAL_GRID_DIMENSION);
        MowerBean mowerBean = Parser.createMowerBean(NORMAL_MOWER_POSITION);
        Set<Pair<Integer, Integer>> mowerList = new HashSet<>();
        ArrayList<String> movementList = Parser.createMovementsList(MOWER_MOVEMENTS);

        for (String movement : movementList) {
            char singleMovement = movement.charAt(0);
            if (singleMovement == MOVEMENT_ACTION) {
                if (!mowerControllerService.mowerMovement(mowerList, grid, mowerBean))
                    break;
            } else mowerControllerService.mowerRotation(mowerBean, singleMovement);
        }

        assertEquals(1, mowerBean.getPositionX());
        assertEquals(3, mowerBean.getPositionY());
        assertEquals(N_DIRECTION, ((Character) mowerBean.getDirection()));
    }
}