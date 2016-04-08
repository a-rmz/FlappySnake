package com.rabidraccoon.flappysnake.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;

import com.rabidraccoon.flappysnake.characters.Snake;

/**
 * Created by alex on 4/8/16.
 */
public class GameLoop implements Runnable {

    int fps;
    boolean running;
    private Game game;
    private Snake snake;
    private SurfaceHolder surfaceHolder;

    public GameLoop(Game game, SurfaceHolder surfaceHolder) {
        fps = 60;
        running = false;
        this.game = game;
        this.snake = game.snake;
        this.surfaceHolder = surfaceHolder;
    }

    @Override
    public void run() {
        running = true;
        int LoopTime = 1000 / fps; // 60 FPS
        long start, elapsed, wait;

        // Initializes what is needed for the Game.

        start= System.nanoTime();
        elapsed = System.nanoTime() - start;
        wait = LoopTime - elapsed / 1000000;

        if(wait < 0) wait = 5;

        while(running){

            if(!hasLost()) {
                update();
                draw();

                if(wait < 0) wait = 5;
                try{
                    Thread.sleep(wait);
                }
                catch(Exception e){
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
    }

    private void draw() {
        synchronized (surfaceHolder) {
            Canvas canvas = surfaceHolder.lockCanvas();
            if(canvas != null) {
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
        canvas.drawColor(Color.BLACK);
        canvas.drawCircle(snake.getPos().getPosX(), snake.getPos().getPosY(), 30, p);
    }

    private boolean hasLost() {
        return !snake.isAlive();
    }

    private void endGame() {
        game.endGame();
    }
}
