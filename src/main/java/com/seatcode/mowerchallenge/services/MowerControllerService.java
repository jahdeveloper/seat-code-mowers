package com.seatcode.mowerchallenge.services;

import com.seatcode.mowerchallenge.models.GridBean;
import com.seatcode.mowerchallenge.models.MowerBean;
import com.seatcode.mowerchallenge.models.Pair;

import java.util.Set;

public interface MowerControllerService {

    MowerBean mowerRotation(MowerBean mowerBean, char degree);

    boolean mowerMovement(Set<Pair<Integer, Integer>> mowerList, GridBean grid, MowerBean mowerBean);

    void stopMower(Set<Pair<Integer, Integer>> mowerList, MowerBean mowerBean);

    boolean checkMowerOnGrid(GridBean grid, MowerBean mowerBean);

    boolean checkMowerCollision(Set<Pair<Integer, Integer>> mowerList, MowerBean mowerBean);
}
