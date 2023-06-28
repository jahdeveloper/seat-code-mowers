package com.seatcode.mowerchallenge.utils;

/**
 * @author Jose Hidalgo
 * Java Class for general constants
 */
public abstract class Constants {

    //Error codes
    public static final String ERROR_CODE_01 = "Code: 01 - Left position wrong, you are out of side grid left.";
    public static final String ERROR_CODE_02 = "Code: 02 - Right position wrong, you are out of side grid right.";
    public static final String ERROR_CODE_03 = "Code: 03 - Top position wrong, you are out of side grid top.";
    public static final String ERROR_CODE_04 = "Code: 04 - Bottom position wrong, you are out of side grid bottom.";
    public static final String ERROR_CODE_05 = "Code: 05 - Position wrong, another mower is occupying that spot.";
    public static final String ERROR_CODE_07 = "Code: 07 - Grid size wrong. Example of use: 5 5.";
    public static final String ERROR_CODE_08 = "Mower position is invalid. Example of use: 5 9 W.";
    public static final String ERROR_CODE_09 = "Mower movement is invalid. Example of use: [L|R|M]+";

    public static final String OK_STATUS = "OK";


    //Program messages
    public static final String ENTER_THE_GRID_COORDINATES = "Enter the grid size: ";
    public static final String ENTER_THE_MOWER_DATA = "Enter the mower data: ";
    public static final String ENTER_THE_MOWER_MOVEMENTS = "Enter the mower movements: ";

    //Direction, rotations and movements
    public static final char MOVEMENT_ACTION = 'M';
    public static final char LEFT_DIRECTION = 'L';
    public static final char DIRECTION_N = 'N';
    public static final char DIRECTION_S = 'S';
    public static final char DIRECTION_W = 'W';
    public static final char DIRECTION_E = 'E';

    //Text
    public final static String[] INTRO_TEXT = {
        "   SSSSSSSSSSSSSSS EEEEEEEEEEEEEEEEEEEEEE               AAA         TTTTTTTTTTTTTTTTTTTTTTT                CCCCCCCCCCCCC     OOOOOOOOO     DDDDDDDDDDDDD      EEEEEEEEEEEEEEEEEEEEEE",
        " SS:::::::::::::::SE::::::::::::::::::::E              A:::A        T:::::::::::::::::::::T             CCC::::::::::::C   OO:::::::::OO   D::::::::::::DDD   E::::::::::::::::::::E",
        "S:::::SSSSSS::::::SE::::::::::::::::::::E             A:::::A       T:::::::::::::::::::::T           CC:::::::::::::::C OO:::::::::::::OO D:::::::::::::::DD E::::::::::::::::::::E",
        "S:::::S     SSSSSSSEE::::::EEEEEEEEE::::E            A:::::::A      T:::::TT:::::::TT:::::T          C:::::CCCCCCCC::::CO:::::::OOO:::::::ODDD:::::DDDDD:::::DEE::::::EEEEEEEEE::::E",
        "S:::::S              E:::::E       EEEEEE           A:::::::::A     TTTTTT  T:::::T  TTTTTT         C:::::C       CCCCCCO::::::O   O::::::O  D:::::D    D:::::D E:::::E       EEEEEE",
        "S:::::S              E:::::E                       A:::::A:::::A            T:::::T         :::::: C:::::C              O:::::O     O:::::O  D:::::D     D:::::DE:::::E             ",
        " S::::SSSS           E::::::EEEEEEEEEE            A:::::A A:::::A           T:::::T         :::::: C:::::C              O:::::O     O:::::O  D:::::D     D:::::DE::::::EEEEEEEEEE   ",
        "  SS::::::SSSSS      E:::::::::::::::E           A:::::A   A:::::A          T:::::T         :::::: C:::::C              O:::::O     O:::::O  D:::::D     D:::::DE:::::::::::::::E   ",
        "    SSS::::::::SS    E:::::::::::::::E          A:::::A     A:::::A         T:::::T                C:::::C              O:::::O     O:::::O  D:::::D     D:::::DE:::::::::::::::E   ",
        "       SSSSSS::::S   E::::::EEEEEEEEEE         A:::::AAAAAAAAA:::::A        T:::::T                C:::::C              O:::::O     O:::::O  D:::::D     D:::::DE::::::EEEEEEEEEE   ",
        "            S:::::S  E:::::E                  A:::::::::::::::::::::A       T:::::T                C:::::C              O:::::O     O:::::O  D:::::D     D:::::DE:::::E             ",
        "            S:::::S  E:::::E       EEEEEE    A:::::AAAAAAAAAAAAA:::::A      T:::::T         ::::::  C:::::C       CCCCCCO::::::O   O::::::O  D:::::D    D:::::D E:::::E       EEEEEE",
        "SSSSSSS     S:::::SEE::::::EEEEEEEE:::::E   A:::::A             A:::::A   TT:::::::TT       ::::::   C:::::CCCCCCCC::::CO:::::::OOO:::::::ODDD:::::DDDDD:::::DEE::::::EEEEEEEE:::::E",
        "S::::::SSSSSS:::::SE::::::::::::::::::::E  A:::::A               A:::::A  T:::::::::T       ::::::    CC:::::::::::::::C OO:::::::::::::OO D:::::::::::::::DD E::::::::::::::::::::E",
        "S:::::::::::::::SS E::::::::::::::::::::E A:::::A                 A:::::A T:::::::::T                   CCC::::::::::::C   OO:::::::::OO   D::::::::::::DDD   E::::::::::::::::::::E",
        " SSSSSSSSSSSSSSS   EEEEEEEEEEEEEEEEEEEEEEAAAAAAA                   AAAAAAATTTTTTTTTTT                      CCCCCCCCCCCCC     OOOOOOOOO     DDDDDDDDDDDDD      EEEEEEEEEEEEEEEEEEEEEE",
        "                                                                                                                                                                                    ",
        "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------",
    };
}