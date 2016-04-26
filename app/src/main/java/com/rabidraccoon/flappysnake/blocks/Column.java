package com.rabidraccoon.flappysnake.blocks;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;

import com.rabidraccoon.flappysnake.utils.Position;

/**
 * Created by alex on 4/21/16.
 */
public class Column {

    protected Position pos;
    private Point size;
    public Bitmap image;

    public Column(Point size, Bitmap image, int mode, int dx) {
        this.size = size;
        this.image = image;
        init(mode, dx);
    }

    private void init(int mode, int dx) {
        // upper column
        if (mode == 1) {
            pos = new Position((size.x/2) * dx, -(8 * size.y / 9), -(size.x * 8 / 720), 0, size.y, 0);
            pos.setDimens(image);
            pos.setMaxX(size.x);
        } else if (mode == -1) { // bottom column
            pos = new Position((size.x/2) * dx, 3 * size.y / 4, -(size.x * 8 / 720), 0, size.y, 0);
            pos.setDimens(image);
            pos.setMaxX(size.x);
        }
    }

    public Position getPos() {
        return pos;
    }

    public void update() {
        pos.movePosX(pos.getMaxX(), 1, true);
    }

    public Rect getCollider() {
        return new Rect(pos.getPosX(), pos.getPosY(), pos.getPosX() + pos.getWidth(), pos.getPosY() + pos.getHeight());
    }


}
