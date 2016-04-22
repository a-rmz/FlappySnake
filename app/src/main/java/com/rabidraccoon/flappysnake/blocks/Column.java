package com.rabidraccoon.flappysnake.blocks;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;

import com.rabidraccoon.flappysnake.R;
import com.rabidraccoon.flappysnake.utils.Position;

/**
 * Created by alex on 4/21/16.
 */
public class Column {

    protected Position pos;
    private Point size;
    public Bitmap image;
    private Rect collider;

    public Column(Point size, Bitmap image, int mode) {
        this.size = size;
        this.image = image;
        init(mode);
    }

    private void init(int mode) {
        // upper column
        if(mode == 1) {
            pos = new Position(size.x/2, -2 * size.y / 3, -(size.x * 5 / 720), 0, size.y, 0);
            //pos.setDimens(image);
            pos.setWidth(size.x / 5);
            pos.setHeight(size.y);
            pos.setMaxX(size.x);
        } else if(mode == -1) { // bottom column
            pos = new Position(size.x/2, 2 * size.y / 3, -(size.x * 5 / 720), 0, size.y, 0);
            //pos.setDimens(image);
            pos.setWidth(size.x / 5);
            pos.setHeight(size.y);
            pos.setMaxX(size.x);
        }
    }


    public void update() {
        pos.movePosX(pos.getMaxX(), 1, true);
    }

    public Rect getCollider() {
        return new Rect(pos.getPosX(), pos.getPosY(), pos.getPosX() + pos.getWidth(), pos.getPosY() + pos.getHeight());
    }


}
