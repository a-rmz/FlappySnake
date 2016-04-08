package com.rabidraccoon.flappysnake.game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by alex on 4/8/16.
 */
public class GameSurface extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener {

    Game game;
    Context context;
    boolean started;

    public GameSurface(Context context, Resources resources) {
        super(context);
        this.context = getContext();
        started = false;
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Point size = new Point();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getSize(size);
        game = new Game(holder, getResources(), size);
        setOnTouchListener(this);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if(game != null) {
            game.stop();
        }

        game = null;

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //start condition
        if(!started) {
            game.start();
            started = true;
        }
        game.onTap(event.getPressure());
        return false;
    }
}
