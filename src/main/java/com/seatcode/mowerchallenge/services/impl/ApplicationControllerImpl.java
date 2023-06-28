package com.seatcode.mowerchallenge.services.impl;

import com.seatcode.mowerchallenge.models.GridBean;
import com.seatcode.mowerchallenge.models.MowerBean;
import com.seatcode.mowerchallenge.models.Pair;
import com.seatcode.mowerchallenge.services.ApplicationController;
import com.seatcode.mowerchallenge.utils.KeyBoardInputsOutputs;
import com.seatcode.mowerchallenge.utils.Parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static com.seatcode.mowerchallenge.utils.Constants.MOVEMENT_ACTION;

/**
 * @author Jose Hidalgo
 * Application Class that initialize and execute movements process, let's cut the Grass :)
 */
public class ApplicationControllerImpl implements ApplicationController {

    private Set<Pair<Integer, Integer>> mowerList;
    private GridBean grid;

    @Override
    public void cutGrass() {
        mowerList = new HashSet<>();
        MowerControllerServiceImpl mowerControllerService = new MowerControllerServiceImpl();
        KeyBoardInputsOutputs keyBoardInputsOutputs = new KeyBoardInputsOutputs();
        keyBoardInputsOutputs.showInitialMessage();
        String gridDimension = keyBoardInputsOutputs.insertGridDimension();
        if (!gridDimension.isEmpty()) {
            while (true) {
                String mowerData = keyBoardInputsOutputs.insertMowerData();
                if (!mowerData.isEmpty()) {
                    this.grid = Parser.createGrid(gridDimension);
                    MowerBean mowerBean = Parser.createMowerBean(mowerData);
                    if (mowerBean != null) {
                        boolean mowerCollisionStatus = mowerControllerService.checkMowerCollision(this.mowerList, mowerBean);
                        boolean mowerOnGridStatus = mowerControllerService.checkMowerOnGrid(this.grid, mowerBean);
                        if (mowerCollisionStatus && mowerOnGridStatus) {
                            String mowerMovements = keyBoardInputsOutputs.insertMowerMovements();
                            if (!mowerMovements.isEmpty()) {
                                ArrayList<String> movementList = Parser.createMovementsList(mowerMovements);
                                for (String movement : movementList) {
                                    char singleMovement = movement.charAt(0);
                                    if (singleMovement == MOVEMENT_ACTION) {
                                        if (!mowerControllerService.mowerMovement(this.mowerList, this.grid, mowerBean))
                                            break;
                                    } else mowerControllerService.mowerRotation(mowerBean, singleMovement);
                                }
                                mowerControllerService.stopMower(this.mowerList, mowerBean);
                                keyBoardInputsOutputs.writeMowerData(mowerBean);
                            }
                        }
                    }
                }
            }
        }
        keyBoardInputsOutputs.closeScanner();
    }

}
