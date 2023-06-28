package com.seatcode.mowerchallenge.utils;

import com.seatcode.mowerchallenge.models.GridBean;
import com.seatcode.mowerchallenge.models.MowerBean;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Jose Hidalgo
 * Java Class that convert data input keyboard to specific object
 */
public class Parser {

    public static MowerBean createMowerBean(String data) {
        String[] dataSplit = data.split(StringUtils.SPACE);
        if (dataSplit.length == 3) {
            int positionX = Integer.valueOf(dataSplit[0]);
            int positionY = Integer.valueOf(dataSplit[1]);
            char direction = dataSplit[2].charAt(0);
            MowerBean mowerBean = new MowerBean(positionX, positionY, direction);
            return mowerBean;
        }
        return null;
    }

    public static ArrayList<String> createMovementsList(String data) {
        String[] dataSplit = data.split(StringUtils.EMPTY);
        if (dataSplit.length > 0) {
            return new ArrayList<>(Arrays.asList(dataSplit));
        }
        return new ArrayList<>();
    }

    public static GridBean createGrid(String data) {
        String[] dataSplit = data.split(StringUtils.SPACE);
        if (dataSplit.length == 2) {
            int xSize = Integer.valueOf(dataSplit[0]);
            int ySize = Integer.valueOf(dataSplit[1]);
            GridBean grid = new GridBean(xSize, ySize);
            return grid;
        }
        return null;
    }
}
