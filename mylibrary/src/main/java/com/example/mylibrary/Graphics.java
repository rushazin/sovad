package com.example.mylibrary;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.Surface;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Locale;

public class Graphics extends Canvas {
    public AssetManager gameManager;

    private Bitmap framer;
    private Canvas canvas;
    private Paint paint;
    private Bitmap texture;



    public Graphics(AssetManager gameManager, Bitmap framer) {
        this.gameManager = gameManager;
        this.framer = framer;


        this.canvas = new Canvas(framer);
        this.paint = new Paint();
    }


    public void clear(int colorOfClear) {
        canvas.drawRGB(colorOfClear, colorOfClear, colorOfClear);
    }
    //square
    public void square(int colorOfClear) {
        int x1 = (getWidth() / 2 ) - 600;
        int x2 = (getWidth() / 2 ) + 600;
        int y1 = (getHeight() / 2) + 300;
        int y2 = (getHeight() / 2) - 300;
        Paint mPaint = new Paint();
        mPaint.setStrokeWidth(20);
        mPaint.setColor(Color.BLACK);
        canvas.drawLine(x1, y1, x2, y1, mPaint);
        canvas.drawLine(x1, y1, x1, y2, mPaint);
    }



    public void pixelDraw(int x, int y, int color) {
        paint.setColor(color);
        canvas.drawPoint(x, y, paint);
    }

    public void drawLine(int startX, int startY, int stopX, int stopY, int color) {
        paint.setColor(color);
        canvas.drawLine(startX, startY, stopX, stopY, paint);
    }

    public void drawGameLine(int startX, int startY, int stopX, int stopY, int color) {
        paint.setColor(color);
        paint.setStrokeWidth(40);
        canvas.drawLine(startX, startY, stopX, stopY, paint);
    }
    public void drawText(String text, int x, int y, int color, int sizeText, Typeface font, Type hint){
        paint.setColor(color);
        paint.setTextSize(sizeText);
        paint.setTypeface(font);
        canvas.drawText(text, x, y, paint);
    }
    public  void drawCircle(int x, int y, int r, int color){
        paint.setColor(color);
        canvas.drawCircle(x, y, r, paint);
    }


    public void drawTexture(Bitmap texture, int x, int y){
        canvas.drawBitmap(texture, x , y, null);
    }

    public  void animat(){
        long x1 = (getWidth() / 2 ) - System.currentTimeMillis();
        long x2 = (getWidth() / 2 ) + System.currentTimeMillis();
        long y1 = (getHeight() / 2) + System.currentTimeMillis();
        long y2 = (getHeight() / 2) - System.currentTimeMillis();
        Paint mPaint = new Paint();
        mPaint.setStrokeWidth(20);
        mPaint.setColor(Color.BLACK);
        canvas.drawLine(x1, y1, x2, y1, mPaint);
    }
    public int getWidth() {
        return framer.getWidth();
    }
    public int getHeight() {
        return framer.getHeight();
    }

    public Bitmap newTexture(String image) throws IOException {
        InputStream inputStream = null;
        try{
            inputStream = gameManager.open(image);
            texture = BitmapFactory.decodeStream(inputStream);
            if(texture == null){
                throw new RuntimeException("Bitmap don't have life :(" + image + "die");
            };
        } catch (IOException e){
            e.printStackTrace();
        }
        if(inputStream != null){
            try{
                inputStream.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return texture;

    }

    public void person(int playerX, int playerY) {
        int color = Color.BLACK;
        int startX = playerX - 108;
        int stopX = playerX + 108;
        Paint paint = new Paint();
        paint.setStrokeWidth(20);
        paint.setColor(Color.BLACK);

        //---
        canvas.drawLine(startX, playerY + 100, stopX, playerY + 100, paint);
        //___
        canvas.drawLine(startX, playerY - 100, stopX,   playerY - 100,   paint);
        //|||
        canvas.drawLine(startX, playerY - 100,startX, playerY + 100, paint);
        //   ||||
        canvas.drawLine(stopX, playerY - 100,stopX,   playerY + 100, paint);



        //face ^-^
        paint.setStrokeWidth(10);

        canvas.drawLine(playerX - 71, playerY,            playerX - 46, playerY - 25, paint);
        canvas.drawLine(playerX - 46, playerY - 25, playerX - 21,       playerY, paint);

        canvas.drawLine(playerX + 71, playerY,            playerX + 46, playerY - 25, paint);
        canvas.drawLine(playerX + 46, playerY - 25, playerX + 21,       playerY, paint);

        canvas.drawLine(playerX - 45, playerY + 25, playerX + 45, playerY + 25, paint);
    }
}
