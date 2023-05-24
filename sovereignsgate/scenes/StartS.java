package com.example.sovereignsgate.scenes;

import android.graphics.Color;
import android.graphics.Paint;

import com.example.mylibrary.Core;
import com.example.mylibrary.Scene;
import com.example.sovereignsgate.R;

import java.util.Collections;

public class StartS extends Scene {

    public StartS(Core core) {
        super(core);
    }

    @Override
    public void update(){
        if(core.touch_listen().getTouchUp(375,1700,300,100)){
            core.setScene(new GameScene(core));
        }
        if(core.touch_listen().getTouchUp(375,1800,300,100)){
            core.setScene(new Settings(core));
        }
        if(core.touch_listen().getTouchUp(375,1900,300,100)){
            core.setScene(new Awards(core));
        }
        if(core.touch_listen().getTouchUp(375,2000,300,100)){
            core.finishAndRemoveTask();
        }
    }

    @Override
    public void drawing() {

        graphics.clear(Color.BLUE);

        graphics.drawText(core.getString(R.string.app_name), 30,200, Color.BLACK, 140, null, null);
        graphics.drawText(core.getString(R.string.new_game),        375, 1700, Color.BLACK, 100, null, null);
        graphics.drawText(core.getString(R.string.settings),         375, 1800, Color.BLACK, 100, null, null);
        graphics.drawText(core.getString(R.string.achieve), 375, 1900, Color.BLACK, 100, null, null);
        graphics.drawText(core.getString(R.string.exit),     375, 2000, Color.BLACK, 100, null, null);
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
