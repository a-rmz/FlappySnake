package com.rabidraccoon.flappysnake.blocks;

import android.graphics.Point;
import android.graphics.Rect;

import com.rabidraccoon.flappysnake.utils.Dimensions;
import com.rabidraccoon.flappysnake.utils.Position;

/**
 * Created by alex on 4/25/16.
 */
public class Counter {

    private Position position;
    private Dimensions dimensions;

    public Counter(Dimensions dimensions, ColumnManager columnManager, int snakeWidth) {
        this.dimensions = dimensions;
        init(columnManager.col1, snakeWidth);
    }

    private void init(Column column, int snakeWidth) {
        position = new Position(column.getPos().getPosX() + column.getPos().getWidth(), 0, column.getPos().getDx(), 0, dimensions.getWidthPx(), dimensions.getHeightPx(), snakeWidth);
        position.setHeight(dimensions.getHeightPx());
        position.setWidth(5);
    }

    public void update() {
        position.movePosXCounter();
    }

    public Rect getCollider() {
        return new Rect(position.getPosX(), position.getPosY(), position.getPosX() + position.getWidth(), position.getPosY() + position.getHeight());
    }
}
