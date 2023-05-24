package com.example.sovereignsgate;


import android.graphics.Canvas;
import android.media.Image;
import android.media.ImageWriter;


public class Sprite extends Canvas {
    private final Image image;

    public Sprite(Image image) {
        this.image = image;
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }
}
