package com.rabidraccoon.flappysnake.game.stateManager;

/**
 * Created by alex on 4/8/16.
 */
public abstract class GameState {

    public abstract void init();
    public abstract void update();
    public abstract void draw();
    public abstract void onTouch(float pressure);

}
