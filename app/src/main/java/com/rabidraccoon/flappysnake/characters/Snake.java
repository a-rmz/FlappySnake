package com.rabidraccoon.flappysnake.characters;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;

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
        image = BitmapFactory.decodeResource(resources, R.drawable.snake8b_small);
        init();
    }

    private void init() {
        pos = new Position(size.x / 2, 0, 0, 60, size.y, (size.x * 7) / 720);
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
        int dy = -(int) ((pressure > 0.19) ? (230 * pressure) : (180 * pressure));
        pos.setDy(dy);
    }

    public Rect getCollider() {
        return new Rect(pos.getPosX() - pos.getWidth() / 2, pos.getPosY(), pos.getPosX() + pos.getWidth() / 2, pos.getPosY() + pos.getHeight());
    }

}
