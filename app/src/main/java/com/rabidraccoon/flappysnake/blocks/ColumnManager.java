package com.rabidraccoon.flappysnake.blocks;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import com.rabidraccoon.flappysnake.R;
import com.rabidraccoon.flappysnake.utils.Dimensions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by alex on 4/21/16.
 */
public class ColumnManager {

    public ArrayList<Column> columns;
    public Bitmap shadow;
    protected Dimensions dimensions;
    protected Resources resources;

    public ColumnManager(Dimensions dimensions, Resources resources) {
        shadow = BitmapFactory.decodeResource(resources, R.drawable.pilar_shadow);

        this.dimensions = dimensions;
        this.resources = resources;

        columns = new ArrayList<>();
        columns.add(new Column(dimensions, resources, 5, 1));
        columns.add(new Column(dimensions, resources, 5, 2));
        columns.add(new Column(dimensions, resources, 5, 3));
        columns.add(new Column(dimensions, resources, 5, 4));
        columns.add(new Column(dimensions, resources, 5, 5));
        columns.add(new Column(dimensions, resources, 5, 6));
    }

    public void update() {
        while (columns.size() < 6) { columns.add(new Column(dimensions, resources, 5, 1)); }

        Column col;
        Iterator<Column> it = columns.iterator();
        while(it.hasNext()) {
            col = it.next();
            col.update();
            if(!col.getPos().isOnScreen()) it.remove();
        }

    }

}
