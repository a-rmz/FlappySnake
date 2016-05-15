package com.rabidraccoon.flappysnake.game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.rabidraccoon.flappysnake.R;
import com.rabidraccoon.flappysnake.background.Background;
import com.rabidraccoon.flappysnake.blocks.ColumnManager;
import com.rabidraccoon.flappysnake.blocks.Counter;
import com.rabidraccoon.flappysnake.characters.Snake;
import com.rabidraccoon.flappysnake.utils.Dimensions;

/**
 * Created by alex on 4/8/16.
 */
public class Game {

    private Thread thread;
    private GameLoop gameLoop;
    private SurfaceHolder surfaceHolder;
    private Resources resources;
    public Snake snake;
    public Background background;
    public ColumnManager columnManager;
    public Counter counter;
    public Dimensions dimensions;
    private boolean hasStarted;
    public Bitmap start;

    // Score
    private int score;

    public Game(SurfaceHolder surfaceHolder, Resources resources, Dimensions dimensions) {
        this.surfaceHolder = surfaceHolder;
        this.resources = resources;

        this.dimensions = dimensions;

        snake = new Snake(dimensions, resources);
        background = new Background(dimensions, resources);
        columnManager = new ColumnManager(dimensions, resources);
        counter = new Counter(dimensions, columnManager, snake.getPos().getWidth());

        this.start = BitmapFactory.decodeResource(resources, R.drawable.btn_start);

        hasStarted = false;
        gameLoop = new GameLoop(this, surfaceHolder);
    }

    public void startGame() {
        hasStarted = true;
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

    public void onTap(MotionEvent event) {
        if(!hasStarted) {
            startGame();
        } else {
            snake.onTap(event);
        }
    }

    public Rect getScreenDimens() {
        return new Rect(0, 0, dimensions.getWidthPx(), dimensions.getHeightPx() + 150);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void increaseScore() {
        this.score++;
        System.out.println("Score: " + score);
    }

    public int getScore() {
        return score;
    }

    public boolean hasStarted() {
        return hasStarted;
    }

    public void onPause() {
        try {
            gameLoop.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onResume() {
        try {
            gameLoop.notify();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
