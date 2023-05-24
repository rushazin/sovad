package com.example.mylibrary;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Date;

public class LoopFW extends SurfaceView implements Runnable{

    float updates = 0;
    float drawing = 0;
    long timer = 0;

    private final int FPS = 60;
    private final int Second = 1000000000/2;
    private boolean running = false;
    Thread gameThread = null;
    Core core;
    Bitmap frameBuffer;
    SurfaceHolder surfaceHolder;
    Canvas canvas;
    Rect rect;

    public LoopFW(Core core, Bitmap  frameBuffer){
        super(core);
        this.frameBuffer = frameBuffer;
        this.core = core;
        this.surfaceHolder = getHolder();
        rect = new Rect();
        canvas = new Canvas();

    }


    @Override
    public void run(){
        timer = System.currentTimeMillis();
        float lastTime = System.nanoTime();
        float comparison = 0;
        int updateTime = Second / FPS;
        while(running){
            //делаем обновление игры ровно в 120 фпс
            float nowTime = System.nanoTime();
            float ElapsingTime = nowTime - lastTime;
            comparison += ElapsingTime/ updateTime;
            if(comparison > 1){
                UpdateGame();
                DrawingGame();
                comparison--;
            }
            //fps, updates counter
            if(System.currentTimeMillis() - timer > 500){
                Date date = new Date();
                //System.out.println("Updates " + updates + " Drawings" + drawing + " " + date.toString());
                updates = 0;
                drawing = 0;
                timer += 1000;
            }
        }
    }

    private void UpdateGame(){
        updates++;
        core.getScene().update();
    }

    private  void DrawingGame(){
        drawing++;
        if(surfaceHolder.getSurface().isValid()){
            canvas = surfaceHolder.lockCanvas();
            canvas.getClipBounds(rect);
            canvas.drawBitmap(frameBuffer, null, rect, null);
            core.getScene().drawing();
            surfaceHolder.unlockCanvasAndPost(canvas);


        }
    }
    public void StartGame(){
        if(running){
            return;
        }
        running = true;
        //run method run()
        gameThread = new Thread(this);
        gameThread.start();
    }

    public  void StopGame() throws InterruptedException {
        if(!running){
            return;
        }
        running = false;
        //Stop game
        gameThread.join();
    }

}
