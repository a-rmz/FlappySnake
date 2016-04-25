package com.rabidraccoon.flappysnake.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.rabidraccoon.flappysnake.blocks.ColumnManager;
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
    private SurfaceHolder surfaceHolder;

    public GameLoop(Game game, SurfaceHolder surfaceHolder) {
        fps = 60;
        running = false;
        this.game = game;
        this.snake = game.snake;
        this.surfaceHolder = surfaceHolder;
        this.columnManager = game.columnManager;
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
        game.background.update();
        game.columnManager.update();
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
        canvas.drawBitmap(game.background.getBg(), game.background.getViewBounds1(), game.getScreenDimens(), t);
        // Background 2
        canvas.drawBitmap(game.background.getBg(), game.background.getViewBounds2(), game.getScreenDimens(), t);
        // Snake collider
        canvas.drawRect(snake.getCollider(), p);
        // Snake bmp
        canvas.drawBitmap(snake.image, snake.getPos().getPosX() - snake.getPos().getWidth() / 2, snake.getPos().getPosY(), t);
        // Columns
        canvas.drawRect(columnManager.col1.getCollider(), t);
        canvas.drawRect(columnManager.col2.getCollider(), t);
        canvas.drawRect(columnManager.col3.getCollider(), t);
        canvas.drawRect(columnManager.col4.getCollider(), t);
    }

    private boolean hasLost() {
        return !snake.isAlive();
    }

    private void endGame() {
        game.endGame();
    }
}
