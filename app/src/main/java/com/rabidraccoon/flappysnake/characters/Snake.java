package com.rabidraccoon.flappysnake.characters;

import android.graphics.Point;

import com.rabidraccoon.flappysnake.utils.Position;

/**
 * Created by alex on 4/8/16.
 */
public class Snake {

    protected Position pos;
    private Point size;

    public Snake(Point size) {
        this.size = size;
        init();
    }

    private void init() {
        pos = new Position(size.x/2, 0, 0, 60, size.x, size.y, 2);
    }

    public void update() {
        pos.movePosY();
    }

    public Position getPos() {
        return this.pos;
    }

    public boolean isAlive() {
        return pos.getPosY() < pos.getMaxY();
    }

    public void onTap(float pressure) {
        int dy = -(int) ((pressure > 0.19) ? (250 * pressure) : (200 * pressure));
        pos.setDy(dy);
    }
}
