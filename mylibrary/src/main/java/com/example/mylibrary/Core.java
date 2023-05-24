package com.example.mylibrary;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Core extends AppCompatActivity {
    private final float frameBuffWidth = 1080;
    private final float frameBuffHeight = 2280;

    public int speed = 3;
    public int restart = 0;


    private LoopFW loopFW;
    private Graphics graphics;
    private Touch_Listen touch_listen;
    private Display display;
    private Point sizeDisplay;
    private Bitmap frameBuff;
    private Scene scene;
    private Scene StartScene;
    private float SceneWidth;
    private float SceneHeight;

    private boolean stateOnPause;
    private boolean stateOnResume;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sizeDisplay = new Point();
        display = getWindowManager().getDefaultDisplay();
        display.getSize(sizeDisplay);
        frameBuff = Bitmap.createBitmap((int) frameBuffWidth, (int) frameBuffHeight, Bitmap.Config.ARGB_8888);
        SceneHeight = frameBuffHeight / sizeDisplay.x;
        SceneWidth = frameBuffWidth / sizeDisplay.y;

        loopFW = new LoopFW(this, frameBuff);
        graphics = new Graphics(getAssets(), frameBuff);
        touch_listen = new Touch_Listen(loopFW, SceneWidth, SceneHeight);

        scene = StartS();
        stateOnPause = false;
        stateOnResume = false;

        setContentView(loopFW);
    }

    public Core() {

    }

    public void onResume() {
        super.onResume();
        scene.resume();
        loopFW.StartGame();
    }

    public void onPause() {
        super.onPause();
        scene.pause();
        stateOnPause = true;
        try {
            loopFW.StopGame();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (isFinishing()) {
            scene.dispose();

        }
    }


    public Graphics getGraphics() {
        return graphics;
    }

    public Touch_Listen touch_listen() {
        return touch_listen;
    }

    public void setScene(Scene sscene) {
        this.scene.pause();
        this.scene.dispose();
        sscene.resume();
        sscene.update();
        this.scene = sscene;
    }


    public Scene getScene() {
        return scene;
    }

    public Scene getStartScene() {
        return scene;
    }

    public Scene StartS() {
        return StartScene;
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putBoolean("MyBoolean", true);
        savedInstanceState.putDouble("myDouble", 1.9);
        savedInstanceState.putInt("MyInt", 10);
        savedInstanceState.putString("MyString", "Welcome back to Android");
        // etc.
    }
}