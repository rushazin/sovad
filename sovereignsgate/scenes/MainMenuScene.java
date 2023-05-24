package com.example.sovereignsgate.scenes;
import android.graphics.Color;

import com.example.mylibrary.Core;
import com.example.mylibrary.Scene;
import com.example.sovereignsgate.R;

public class MainMenuScene extends Scene {
    public MainMenuScene(Core core) {
        super(core);
    }
    public boolean restart = false;

    @Override
    public void update() {
    }
    @Override
    public void drawing() {
        graphics.clear(Color.BLUE);
        graphics.drawText(core.getString(R.string.app_name), 100,100, Color.BLACK, 60, null);
        graphics.drawText(core.getString(R.string.new_game), 20, 300, Color.BLACK, 40, null);
        graphics.drawText(core.getString(R.string.settings), 20, 350, Color.BLACK, 60, null);
        graphics.drawText(core.getString(R.string.achieve),  20, 400, Color.BLACK, 60, null);
        graphics.drawText(core.getString(R.string.exit),     20, 500, Color.BLACK, 60, null);

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
