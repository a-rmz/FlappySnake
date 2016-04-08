package com.rabidraccoon.flappysnake.characters;

import android.graphics.Point;
import android.util.DisplayMetrics;

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
        pos = new Position(size.x/2, size.y/2, 0, 60, size.x, size.y, 2);
    }

    public void update() {
        pos.movePosY();
    }

    public Position getPos() {
        return this.pos;
    }

    public void onTap() {
        pos.setDy(-60);
    }
}
