package com.rabidraccoon.flappysnake.blocks;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import com.rabidraccoon.flappysnake.R;
import com.rabidraccoon.flappysnake.utils.Dimensions;

/**
 * Created by alex on 4/21/16.
 */
public class ColumnManager {

    public Column col1;
    public Column col2;
    public Column col3;
    public Column col4;

    public ColumnManager(Dimensions dimensions, Resources resources) {
        Bitmap img = BitmapFactory.decodeResource(resources, R.drawable.pilar);

//        col1 = new Column(screenSize, img, 1);
//        col2 = new Column(screenSize, img, 1);
//        col3 = new Column(screenSize, img, 1);
//        col4 = new Column(screenSize, img, 1);

    }

    public void update() {
//        col1.update();
//        col2.update();
//        col3.update();
//        col4.update();
    }

}
