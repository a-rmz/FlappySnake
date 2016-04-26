package com.rabidraccoon.flappysnake.game;

import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.SurfaceHolder;

import com.rabidraccoon.flappysnake.background.Background;
import com.rabidraccoon.flappysnake.blocks.ColumnManager;
import com.rabidraccoon.flappysnake.blocks.Counter;
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
    public Background background;
    public ColumnManager columnManager;
    public Counter counter;
    private Point size;

    // Score
    private int score;

    public Game(SurfaceHolder surfaceHolder, Resources resources, Point size) {
        this.surfaceHolder = surfaceHolder;
        this.resources = resources;

        this.size = size;

        snake = new Snake(size, resources);
        background = new Background(size, resources);
        columnManager = new ColumnManager(size, resources);
        counter = new Counter(size, columnManager, snake.getPos().getWidth());

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

    public Rect getScreenDimens() {
        return new Rect(0, 0, size.x, size.y + 150);
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
}
