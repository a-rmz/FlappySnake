package com.rabidraccoon.flappysnake.blocks;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;

import com.rabidraccoon.flappysnake.utils.Position;

import java.util.Random;

/**
 * Created by alex on 4/21/16.
 */
public class Column {

    protected Position pos;
    private Point size;
    public Bitmap image;
    private Random rand;

    public Column(Point size, Bitmap image, int dx) {
        this.size = size;
        this.image = image;
        rand = new Random(System.currentTimeMillis());
        init(dx);
    }

    private void init(int dx) {
        pos = new Position(size.x, rand.nextInt(size.y), -(size.x * 8 / 720), 0, size.y, 0);
        pos.setDimens(image);
        pos.setPosX(size.x);
        pos.setPosY(rand.nextInt(size.y) - pos.getHeight());
        pos.setDx(0);
        pos.setDy(0);
        pos.setMaxY(size.y);
        pos.setMaxX(size.x);

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
