package com.example.sovereignsgate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyDraw extends View {
    private Context context;
    private Paint paint;
    private int h;
    private int w;
    Canvas canvas;

    public MyDraw(Context context) {
        super(context);
        drawCircles(canvas, 10, 5, 60);
    }

    public void drawCircles(Canvas canvas, int x, int y, int r) {
        canvas.drawCircle(x, y, r, paint);
        Canvas grid = new Canvas(Bitmap.createBitmap(h, w, Bitmap.Config.ARGB_8888));
        grid.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        if (r > 50) {
            drawCircles(canvas, x, y - r, r / 2);
            drawCircles(canvas, x + r, y, r / 2);
            drawCircles(canvas, x, y + r, r / 2);
            drawCircles(canvas, x - r, y, r / 2);
        }
    }
}
