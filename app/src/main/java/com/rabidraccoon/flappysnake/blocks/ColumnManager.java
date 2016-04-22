package com.rabidraccoon.flappysnake.blocks;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import com.rabidraccoon.flappysnake.R;

/**
 * Created by alex on 4/21/16.
 */
public class ColumnManager {

    public Column col1;
    public Column col2;

    public ColumnManager(Point screenSize, Resources resources) {
        Bitmap img = BitmapFactory.decodeResource(resources, R.drawable.snake_small);

        col1 = new Column(screenSize, img, 1);
        col2 = new Column(screenSize, img, -1);

    }

    public void update() {
        col1.update();
        col2.update();
    }

}
