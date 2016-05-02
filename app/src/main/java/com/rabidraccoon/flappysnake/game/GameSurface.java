package com.rabidraccoon.flappysnake.game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;

import com.rabidraccoon.flappysnake.utils.Dimensions;

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
        int density = getResources().getConfiguration().densityDpi;
        int width = getResources().getConfiguration().screenWidthDp;
        int height = getResources().getConfiguration().screenHeightDp;
        game = new Game(holder, getResources(), new Dimensions(width, height, density));
        setOnTouchListener(this);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (game != null) {
            game.stop();
        }

        game = null;

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //start condition
        if (!started) {
            game.start();
            started = true;
        }
        game.onTap(event.getPressure());
        return false;
    }


}
