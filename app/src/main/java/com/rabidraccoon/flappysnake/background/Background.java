package com.rabidraccoon.flappysnake.background;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;

import com.rabidraccoon.flappysnake.R;
import com.rabidraccoon.flappysnake.utils.Dimensions;
import com.rabidraccoon.flappysnake.utils.Position;

/**
 * Created by alex on 4/11/16.
 */
public class Background {

    Dimensions dimensions;
    Position position;
    Bitmap bg;
    Rect rect;

    public Background(Dimensions dimensions, Resources resources) {
        position = new Position();
        this.dimensions = dimensions;
        bg = BitmapFactory.decodeResource(resources, R.drawable.background);
        position.setDimens(dimensions.getWidthPx(), dimensions.getHeightPx());
        rect = new Rect(0, 0, position.getWidth(), position.getHeight());
    }

    public Bitmap getBg() {
        return bg;
    }

    public Rect getViewBounds() {
        return this.rect;
    }

    public Position getPosition() {
        return position;
    }
}
