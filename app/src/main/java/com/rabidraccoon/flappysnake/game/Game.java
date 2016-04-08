package com.rabidraccoon.flappysnake.game;

import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;

import com.rabidraccoon.flappysnake.characters.Snake;

/**
 * Created by alex on 4/8/16.
 */
public class Game {

    private Thread thread;
    private GameLoop gameLoop;
    private SurfaceHolder surfaceHolder;
    private Resources resources;
    public Snake snake;
    private Point size;

    public Game(SurfaceHolder surfaceHolder, Resources resources, Point size) {
        this.surfaceHolder = surfaceHolder;
        this.resources = resources;

        this.size = size;

        snake = new Snake(size);

        gameLoop = new GameLoop(this, surfaceHolder);
    }

    public void start() {
        thread = new Thread(gameLoop);
        thread.start();
    }

    public void stop() {
        gameLoop.stop();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void endGame() {
        System.out.println("Game ended");
        stop();
    }

    public void onTap(float pressure) {
        snake.onTap(pressure);

    }

}
