package com.example.sovereignsgate.scenes;

import android.graphics.Color;

import com.example.mylibrary.Core;
import com.example.mylibrary.Scene;

public class Settings extends Scene {
    public Settings(Core core) {
        super(core);
    }
    public int dr = 3;

    @Override
    public void update() {
        if(core.touch_listen().getTouchUp(50,100,400,120)){
            core.setScene(new StartS(core));
        }
        if(core.touch_listen().getTouchUp(100,700,100,120)){
            dr -= 1;
            core.speed -= 1;
        }
        if(core.touch_listen().getTouchUp(600,700,100,120)){
            dr += 1;
            core.speed += 1;
        }
        if(dr == 1){
            graphics.drawText("очень медленно",210,   700, Color.WHITE, 50, null, null);
        }
        if(dr == 2){
            graphics.drawText("медленно",      290,   700, Color.WHITE, 50, null, null);
        }
        if(dr == 3){
            graphics.drawText("средне",        300,   700, Color.WHITE, 50, null, null);
        }
        if(dr == 4){
            graphics.drawText("быстро",        300,   700, Color.WHITE, 50, null, null);
        }
        if(dr == 5){
            graphics.drawText("очень быстро",  210,   700, Color.WHITE, 50, null, null);
        }


    }

    @Override
    public void drawing() {
        graphics.clear(Color.BLACK);
        graphics.drawText("Назад",        50,   100, Color.WHITE, 120, null, null);
        graphics.drawText("Настройки",    50,   200, Color.WHITE, 120, null, null);
        graphics.drawText("Скорость:",    50,   500, Color.WHITE, 80, null, null);
        graphics.drawText("—",    100,   700, Color.WHITE, 90, null, null);
        graphics.drawText("+",    600,   700, Color.WHITE, 90, null, null);


    }


    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
