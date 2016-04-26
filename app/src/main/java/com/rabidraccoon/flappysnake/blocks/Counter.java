package com.rabidraccoon.flappysnake.blocks;

import android.graphics.Point;
import android.graphics.Rect;

import com.rabidraccoon.flappysnake.utils.Position;

/**
 * Created by alex on 4/25/16.
 */
public class Counter {

    private Position position;
    private Point size;

    public Counter(Point size, ColumnManager columnManager, int snakeWidth) {
        this.size = size;
        init(columnManager.col1, snakeWidth);
    }

    private void init(Column column1, int snakeWidth) {
        position = new Position(column1.getPos().getPosX() + column1.getPos().getWidth(), 0, column1.getPos().getDx(), 0, size.x, size.y, snakeWidth);
        position.setHeight(size.y);
        position.setWidth(5);
    }

    public void update() {
        position.movePosXCounter();
    }

    public Rect getCollider() {
        return new Rect(position.getPosX(), position.getPosY(), position.getPosX() + position.getWidth(), position.getPosY() + position.getHeight());
    }
}
