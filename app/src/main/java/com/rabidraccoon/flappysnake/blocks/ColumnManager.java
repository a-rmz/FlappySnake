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
    public Column col5;
    public Column col6;
    public Column col7;
    public Column col8;

    public ColumnManager(Dimensions dimensions, Resources resources) {

        col1 = new Column(dimensions, resources, 5, 1);
        col2 = new Column(dimensions, resources, 5, 2);
        col3 = new Column(dimensions, resources, 5, 3);
        col4 = new Column(dimensions, resources, 5, 4);
        col5 = new Column(dimensions, resources, 5, 5);
        col6 = new Column(dimensions, resources, 5, 6);
        col7 = new Column(dimensions, resources, 5, 7);
        col8 = new Column(dimensions, resources, 5, 8);

    }

    public void update() {
        col1.update();
        col2.update();
        col3.update();
        col4.update();
        col5.update();
        col6.update();
        col7.update();
        col8.update();
    }

}
