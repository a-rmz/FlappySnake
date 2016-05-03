package com.rabidraccoon.flappysnake.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.rabidraccoon.flappysnake.blocks.Column;
import com.rabidraccoon.flappysnake.blocks.ColumnManager;
import com.rabidraccoon.flappysnake.blocks.Counter;
import com.rabidraccoon.flappysnake.characters.Snake;

/**
 * Created by alex on 4/8/16.
 */
public class GameLoop implements Runnable {

    int fps;
    boolean running;
    private Game game;
    private Snake snake;
    private ColumnManager columnManager;
    public Counter counter;
    private SurfaceHolder surfaceHolder;

    public GameLoop(Game game, SurfaceHolder surfaceHolder) {
        fps = 60;
        running = false;
        this.game = game;
        this.snake = game.snake;
        this.surfaceHolder = surfaceHolder;
        this.columnManager = game.columnManager;
        this.counter = game.counter;
    }

    @Override
    public void run() {
        running = true;
        int LoopTime = 1000 / fps; // 60 FPS
        long start, elapsed, wait;

        // Initializes what is needed for the Game.

        start = System.nanoTime();
        elapsed = System.nanoTime() - start;
        wait = LoopTime - elapsed / 1000000;

        if (wait < 0) wait = 5;

        while (running) {

            if (!hasLost()) {
                update();
                draw();

                if (wait < 0) wait = 5;
                try {
                    Thread.sleep(wait);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                endGame();
            }

        }
    }

    public void stop() {
        running = false;
    }

    private void update() {
        snake.update();
        game.columnManager.update();
        counter.update();
        if(counter.getCollider().intersect(snake.getCollider().left, snake.getCollider().top, snake.getCollider().left, snake.getCollider().bottom)) game.increaseScore();
    }

    private void draw() {
        synchronized (surfaceHolder) {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                try {
                    updateCanvas(canvas);
                } catch (Exception e) {

                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

    private void updateCanvas(Canvas canvas) {
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.WHITE);
        p.setStyle(Paint.Style.STROKE);
        Paint t = new Paint(Paint.ANTI_ALIAS_FLAG);
        t.setColor(Color.BLACK);
        t.setStyle(Paint.Style.FILL);
        canvas.drawColor(Color.BLACK);
        // Background 1
        canvas.drawBitmap(game.background.getBg(), game.background.getViewBounds(), game.getScreenDimens(), t);

        // Snake collider
        canvas.drawRect(snake.getCollider(), p);
        // Snake bmp
        canvas.drawBitmap(snake.image, snake.getPos().getPosX() - snake.getPos().getWidth() / 2, snake.getPos().getPosY(), t);
        // Counter
        canvas.drawRect(counter.getCollider(), p);

        // Shadows
        for(Column c : columnManager.columns) canvas.drawBitmap(columnManager.shadow, c.getPos().getPosX(), c.getPos().getPosY(), t);
        // Columns
        for(Column c : columnManager.columns) canvas.drawBitmap(c.image, c.getPos().getPosX(), c.getPos().getPosY(), t);

    }

    private boolean hasLost() {
        return false; /*
                // First column pair
            (    (snake.getCollider().intersect(columnManager.col1.getCollider())
                    || snake.getCollider().intersect(columnManager.col2.getCollider()))
            ||
                // Second column pair
                (snake.getCollider().intersect(columnManager.col3.getCollider())
                    || snake.getCollider().intersect(columnManager.col4.getCollider()))
            ) ||
                // Position
            !snake.isAlive();*/
    }

    private void endGame() {
        game.endGame();
    }
}
