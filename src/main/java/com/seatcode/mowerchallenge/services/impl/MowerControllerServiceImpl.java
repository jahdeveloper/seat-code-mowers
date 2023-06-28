package com.seatcode.mowerchallenge.services.impl;

import com.seatcode.mowerchallenge.models.GridBean;
import com.seatcode.mowerchallenge.models.MowerBean;
import com.seatcode.mowerchallenge.models.Pair;
import com.seatcode.mowerchallenge.services.MowerControllerService;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;

import static com.seatcode.mowerchallenge.utils.Constants.*;

/**
 * @author Jose Hidalgo
 * Controller Class that control mower movement
 */
public class MowerControllerServiceImpl implements MowerControllerService {

    /**
     * Rotates a mower by a specified angle.
     *
     * @param mowerBean  a MowerBean object representing the mower to rotate
     * @param degree     a boolean indicating whether the rotation angle is specified in degrees
     * @return the updated MowerBean object after the rotation
     */
    private MowerBean mowerRotation(MowerBean mowerBean, boolean degree) {

        char direction = mowerBean.getDirection();
        char newDirection;
        switch (direction) {
            case DIRECTION_N:
                newDirection = degree ? DIRECTION_E : DIRECTION_W;
                break;
            case DIRECTION_S:
                newDirection = degree ? DIRECTION_W : DIRECTION_E;
                break;
            case DIRECTION_E:
                newDirection = degree ? DIRECTION_S : DIRECTION_N;
                break;
            case DIRECTION_W:
                newDirection = degree ? DIRECTION_N : DIRECTION_S;
                break;
            default:
                newDirection = direction;
        }
        mowerBean.setDirection(newDirection);
        return mowerBean;
    }

    @Override

    public MowerBean mowerRotation(MowerBean mowerBean, char direction) {
        if (direction == LEFT_DIRECTION) return mowerRotation(mowerBean, false);
        else return mowerRotation(mowerBean, true);
    }
    /**
     * Performs the movement of a mower in the system.
     *
     * @param mowerList   a set of (x, y) coordinates representing the location of the mowers
     * @param grid        a GridBean object representing the grid
     * @param mowerBean   a MowerBean object representing the details of the mower
     * @return true if the movement was successful, otherwise false
     */
    @Override
    public boolean mowerMovement(Set<Pair<Integer, Integer>> mowerList, GridBean grid, MowerBean mowerBean) {

        char direction = mowerBean.getDirection();

        switch (direction) {
            case DIRECTION_N:
                mowerBean.setPositionY(mowerBean.getPositionY() + 1);
                break;
            case DIRECTION_S:
                mowerBean.setPositionY(mowerBean.getPositionY() - 1);
                break;
            case DIRECTION_E:
                mowerBean.setPositionX(mowerBean.getPositionX() + 1);
                break;
            case DIRECTION_W:
                mowerBean.setPositionX(mowerBean.getPositionX() - 1);
                break;
        }
        if (!checkMowerOnGrid(grid, mowerBean)) return false;
        if (!checkMowerCollision(mowerList, mowerBean)) return false;
        return true;
    }

    /**
     * Stops a mower in the system.
     *
     * @param mowerList   a set of (x, y) coordinates representing the location of the mowers
     * @param mowerBean   a MowerBean object representing the details of the mower to stop
     */
    @Override
    public void stopMower(Set<Pair<Integer, Integer>> mowerList, MowerBean mowerBean) {
        Pair<Integer, Integer> mowerPair = new Pair<>(mowerBean.getPositionX(), mowerBean.getPositionY());
        mowerList.add(mowerPair);
    }

    /**
     * Checks if a mower is on the grid.
     *
     * @param grid       a GridBean object representing the system grid
     * @param mowerBean  a MowerBean object representing the mower to check
     * @return true if the mower it's into the grid, false otherwise
     */
    @Override
    public boolean checkMowerOnGrid(GridBean grid, MowerBean mowerBean) {
        String statusCode = StringUtils.EMPTY;

        int xPosition = mowerBean.getPositionX();
        int yPosition = mowerBean.getPositionY();
        if (yPosition < 0) statusCode = ERROR_CODE_04;
        else if (xPosition < 0) statusCode = ERROR_CODE_01;
        else if (yPosition > grid.getySize()) statusCode = ERROR_CODE_03;
        else if (xPosition > grid.getxSize()) statusCode = ERROR_CODE_02;

        if (!statusCode.isEmpty()) {
            System.out.println(statusCode);
            return false;
        }
        return true;

    }

    /**
     * Checks if a mower has collided with any other mowers.
     *
     * @param mowerList   a set of (x, y) coordinates representing the locations of all mowers
     * @param mowerBean   a MowerBean object representing the mower to check for collision
     * @return false if the mower has collided with any other mowers, true otherwise
     */
    @Override
    public boolean checkMowerCollision(Set<Pair<Integer, Integer>> mowerList, MowerBean mowerBean) {
        int xPosition = mowerBean.getPositionX();
        int yPosition = mowerBean.getPositionY();
        Pair<Integer, Integer> mowerPair = new Pair<>(xPosition, yPosition);
        boolean collision = mowerList.contains(mowerPair);
        if (collision) {
            System.out.println(ERROR_CODE_05);
            return false;
        }
        return true;
    }


}
