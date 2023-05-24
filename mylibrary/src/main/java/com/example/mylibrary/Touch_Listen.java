package com.example.mylibrary;

import android.view.MotionEvent;
import android.view.View;

public class Touch_Listen implements View.OnTouchListener {

    float touchX;
    float touchY;

    boolean isTouchUp;
    boolean isTouchDown;

    float sceneWidth;
    float sceneHeight;

    public Touch_Listen(View view, float sceneWidth, float sceneHeight) {
        view.setOnTouchListener(this);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {

        synchronized (this){
            isTouchUp = false;
            isTouchDown = false;
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    touchX = event.getX();
                    touchY = event.getY();
                    System.out.println(touchX);
                    System.out.println(touchY);
                    isTouchDown = true;
                    isTouchUp = false;
                    break;

                case MotionEvent.ACTION_UP:
                    touchX = event.getX();
                    touchY = event.getY();
                    isTouchUp = true;
                    isTouchDown = false;
                    break;
            }
        }
        return true;
    }

    public boolean getTouchUp(int x, int y, int touchWidth, int touchHeight){
        if(isTouchUp){
            if(touchX >= x && touchX <= x + touchWidth - 1 && touchY <= y && touchY >= y - (touchHeight- 1)){
                isTouchUp = false;
                return  true;
            }
        }
        return false;
    }
    public boolean getTouchDown(int x, int y, int touchWidth, int touchHeight){
        if(isTouchDown){
            if(touchX >= x && touchX <= x + touchWidth - 1 && touchY <= y && touchY >= y - (touchHeight- 1)){
                isTouchDown = false;
                return  true;
            }
        }
        return false;
    }
}
