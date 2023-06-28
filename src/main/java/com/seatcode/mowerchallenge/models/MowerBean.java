package com.seatcode.mowerchallenge.models;

public class MowerBean {

    private int positionX;
    private int positionY;
    private char direction;

    public MowerBean(int positionX, int positionY, char direction) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

}
