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
    Position position;
    Bitmap bg;

    public Background(Point screenSize, Resources resources) {
        position = new Position();
        bg = BitmapFactory.decodeResource(resources, R.drawable.background);
        position.setDimens(bg);
        init();
    }

    public void init() {
        position.setDx(2);
    }

    public void update() {
        position.movePosX();
    }

    public Bitmap getBg() {
        return bg;
    }

    public Rect getViewBounds() {
        return new Rect(position.getPosX(), 0, (position.getWidth() * 2 / 3) + position.getPosX(), position.getHeight());
    }
}
