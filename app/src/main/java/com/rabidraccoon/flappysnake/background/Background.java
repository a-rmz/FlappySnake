package com.rabidraccoon.flappysnake.background;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;

import com.rabidraccoon.flappysnake.R;
import com.rabidraccoon.flappysnake.utils.Position;

/**
 * Created by alex on 4/11/16.
 */
public class Background {

    Point screenSize;
    Position position1, position2;
    Bitmap bg;

    public Background(Point screenSize, Resources resources) {
        position1 = new Position();
        position2 = new Position();
        this.screenSize = screenSize;
        bg = BitmapFactory.decodeResource(resources, R.drawable.background);
        position1.setDimens(bg);
        position2.setDimens(bg);
        init();
    }

    public void init() {
        position1.setDx(3);
        position1.setMaxX(screenSize.x);
        position2.setDx(3);
        position2.setMaxX(screenSize.x);
        position2.setPosX(-position2.getWidth() + 3);
    }

    public void update() {
        position1.movePosX(position1.getWidth(), -1);
        position2.movePosX(position2.getWidth(), -1);
    }

    public Bitmap getBg() {
        return bg;
    }

    public Rect getViewBounds1() {
        return new Rect(position1.getPosX(), 0, position1.getMaxX() + position1.getPosX(), position1.getHeight());
    }

    public Rect getViewBounds2() {
        return new Rect(position2.getPosX(), 0, position2.getMaxX() + position2.getPosX(), position2.getHeight());
    }

    public Position getPosition1() {
        return position1;
    }

    public Position getPosition2() {
        return this.position2;
    }
}
