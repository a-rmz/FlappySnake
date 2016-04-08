package com.rabidraccoon.flappysnake.utils;

/**
 * Created by alex on 4/8/16.
 */
public class Position {

    private int posX;
    private int posY;
    private int dx;
    private int dy;
    private int maxX;
    private int maxY;
    private int gravity;

    public Position(int posX, int posY, int dx, int dy, int maxX, int maxY, int gravity) {
        this.posX = posX;
        this.posY = posY;
        this.dx = dx;
        this.dy = dy;
        this.maxX = maxX;
        this.maxY = maxY;
        this.gravity = gravity;
    }

    public Position() {
        this.posX = 0;
        this.posY = 0;
        this.dx = 0;
        this.dy = 0;
        this.maxX = 0;
        this.maxY = 0;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        if(posX < 0) this.posX = 0;
        else this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        if(posY > maxY) this.posY = maxY;
        else this.posY = posY;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void movePosX() {
        setPosX(posX + dx);
    }

    public void movePosY() {
        dy = (dy <= 0) ? dy+3 : dy+gravity;
        setPosY(posY + dy);
    }


}
