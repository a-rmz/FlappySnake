package com.rabidraccoon.flappysnake.characters;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;

import com.rabidraccoon.flappysnake.R;
import com.rabidraccoon.flappysnake.utils.Dimensions;
import com.rabidraccoon.flappysnake.utils.Position;

/**
 * Created by alex on 4/8/16.
 */
public class Snake {

    protected Position pos;
    private Dimensions dimensions;
    public Bitmap image;

    public Snake(Dimensions dimensions, Resources resources) {
        this.dimensions = dimensions;
        image = BitmapFactory.decodeResource(resources, R.drawable.quetz);
        init();
    }

    private void init() {
        pos = new Position(dimensions.getWidthPx() / 2, 0, 0, 60, dimensions.getHeightPx(), dimensions.dpToPx(10));
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
        //int dy = -(int) ((pressure > 0.19) ? (270 * pressure) : (220 * pressure));
        pos.setDy(dimensions.dpToPx(-70));
    }

    public Rect getCollider() {
        return new Rect(pos.getPosX() - pos.getWidth() / 2, pos.getPosY(), pos.getPosX() + pos.getWidth() / 2, pos.getPosY() + pos.getHeight());
    }

}
