package com.rabidraccoon.flappysnake.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by alex on 4/8/16.
 */
public class Position {

    private int posX;
    private int posY;
    private int dx;
    private int dy;
    private int maxY;
    private int maxX;
    private int gravity;
    private int width;
    private int height;

    public Position(int posX, int posY, int dx, int dy, int maxY, int gravity) {
        this.posX = posX;
        this.posY = posY;
        this.dx = dx;
        this.dy = dy;
        this.maxY = maxY;
        this.gravity = gravity;
    }

    public Position() {
        this.posX = 0;
        this.posY = 0;
        this.dx = 0;
        this.dy = 0;
        this.maxY = 0;
        this.maxX = 0;
    }

    public int getDy() {
        return dy;
    }
    public int getDx() {
        return dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getPosY() {
        return posY;
    }

    public int getPosX() { return posX; }

    public void setPosY(int posY) {
        if(posY >= 0)  this.posY = posY;
        else {
            this.posY = 0;
            setDy(gravity);
        }
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getMaxY() {
        return this.maxY;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMaxX() {
        return maxX;
    }

    public void movePosY() {
        dy = (dy <= 0) ? dy+3 : dy+gravity;
        setPosY(posY + dy);
    }

    public void movePosX(int param, int dir) {
        if(this.posX < param) {
            setPosX(posX + dx);
        } else {
            setPosX(dir * param);
        }
    }

    public void movePosX(int param, int dir, boolean inv) {
        if(this.posX > -width) {
            setPosX(posX + dx);
        } else {
            setPosX(dir * param);
        }
    }

    public void setDimens(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setDimens(Drawable drawable) {
        width = drawable.getBounds().width();
        height = drawable.getBounds().height();
    }

    public void setDimens(Bitmap bitmap) {
        width = bitmap.getWidth();
        height = bitmap.getHeight();
    }



    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
