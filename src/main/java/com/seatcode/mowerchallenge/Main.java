package com.seatcode.mowerchallenge;

import com.seatcode.mowerchallenge.services.impl.ApplicationControllerImpl;

/**
 * @author Jose Hidalgo
 * Main java class
 */
public class Main {

    public static void main(String[] args) {
        ApplicationControllerImpl applicationController = new ApplicationControllerImpl();
        applicationController.cutGrass();
    }
}