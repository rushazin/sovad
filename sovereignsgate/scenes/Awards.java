package com.example.sovereignsgate.scenes;

import android.graphics.Color;

import com.example.mylibrary.Core;
import com.example.mylibrary.Scene;
import com.example.sovereignsgate.R;

public class Awards extends Scene {
    public Awards(Core core) {
        super(core);
    }


    public int getAward(int score) {
        return score;
    }

    @Override
    public void update() {
        if(core.touch_listen().getTouchUp(50,100,400,120)){
            core.setScene(new StartS(core));
        }
    }

    @Override
    public void drawing() {
        graphics.clear(Color.BLACK);
        graphics.drawText("BACK",      50,   100, Color.WHITE, 120, null, null);
        graphics.drawText("AWARDS",    50,   200, Color.WHITE, 120, null, null);
        graphics.drawText("BEST SCORE",200,  400, Color.BLACK, 100, null, null);
        graphics.drawText("0",         200, 500, Color.BLACK, 100, null, null);

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
