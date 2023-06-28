package com.seatcode.mowerchallenge.utils;

import com.seatcode.mowerchallenge.models.MowerBean;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

import static com.seatcode.mowerchallenge.utils.Constants.*;

/**
 * @author Jose Hidalgo
 * Java Class check input data keyboard and print output message
 */
public class KeyBoardInputsOutputs {

    private static final String GRID_REGEX = "[1-9]+ [1-9]+";
    private static final String MOWER_DATA_REGEX = "[0-9]+ [0-9]+ [N|E|S|W]+";
    private static final String MOWER_MOVEMENTS_REGEX = "[R|L|M]+";
    private Scanner scanner;

    public KeyBoardInputsOutputs() {
        this.scanner = new Scanner(System.in);
    }

    private String isValidGrid(String position) {
        if (!position.matches(GRID_REGEX)) {
            System.out.println(ERROR_CODE_07);
            return ERROR_CODE_07;
        }
        return OK_STATUS;
    }

    private String isValidMowerData(String data) {
        if (!data.matches(MOWER_DATA_REGEX)) {
            System.out.println(ERROR_CODE_08);
            return ERROR_CODE_08;
        }
        return OK_STATUS;
    }

    private String isValidMowerMovements(String data) {
        if (!data.matches(MOWER_MOVEMENTS_REGEX)) {
            System.out.println(ERROR_CODE_09);
            return ERROR_CODE_09;
        }
        return OK_STATUS;
    }

    public String insertGridDimension() {
        System.out.println(ENTER_THE_GRID_COORDINATES);
        String gridData = this.scanner.nextLine();
        String status = isValidGrid(gridData);
        return status.equalsIgnoreCase(OK_STATUS) ? gridData : StringUtils.EMPTY;
    }

    public String insertMowerData() {
        System.out.println(ENTER_THE_MOWER_DATA);
        String mowerData = this.scanner.nextLine();
        String status = isValidMowerData(mowerData);
        return status.equalsIgnoreCase(OK_STATUS) ? mowerData : StringUtils.EMPTY;
    }

    public String insertMowerMovements() {
        System.out.println(ENTER_THE_MOWER_MOVEMENTS);
        String mowerMovementsData = this.scanner.nextLine();
        String status = isValidMowerMovements(mowerMovementsData);
        return status.equalsIgnoreCase(OK_STATUS) ? mowerMovementsData : StringUtils.EMPTY;
    }

    public void closeScanner() {
        this.scanner.close();
    }

    public void writeMowerData(MowerBean mowerBean) {
        System.out.println(mowerBean.getPositionX() + StringUtils.SPACE + mowerBean.getPositionY() + StringUtils.SPACE + mowerBean.getDirection());
    }

    public void showInitialMessage() {
        for (int i = 0; i < INTRO_TEXT.length; i++) {
            System.out.println(INTRO_TEXT[i]);
        }
    }
}
