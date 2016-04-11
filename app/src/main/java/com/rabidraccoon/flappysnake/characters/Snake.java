package com.rabidraccoon.flappysnake.characters;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.rabidraccoon.flappysnake.R;
import com.rabidraccoon.flappysnake.utils.Position;

/**
 * Created by alex on 4/8/16.
 */
public class Snake {

    protected Position pos;
    private Point size;
    public Bitmap image;

    public Snake(Point size, Resources resources) {
        this.size = size;
        image = BitmapFactory.decodeResource(resources, R.drawable.snake_small);
        init();
    }

    private void init() {
        pos = new Position(size.x/2, 0, 0, 60, size.y, 2);
        pos.setDimens(image);
    }

    public void update() {
        pos.movePosY();
    }

    public Position getPos() {
        return this.pos;
    }

    public boolean isAlive() {
        return pos.getPosY() < (pos.getMaxY() + 2 * pos.getHeight());
    }

    public void onTap(float pressure) {
        int dy = -(int) ((pressure > 0.19) ? (250 * pressure) : (200 * pressure));
        pos.setDy(dy);
    }

    public Rect getCollider() {
        return new Rect(pos.getPosX()-pos.getWidth()/2, pos.getPosY(), pos.getPosX()+pos.getWidth()/2, pos.getPosY()+pos.getHeight());
//        return new Rect(200, 200, 500, 600);
    }

}
