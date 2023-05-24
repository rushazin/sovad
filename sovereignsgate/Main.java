package com.example.sovereignsgate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mylibrary.Core;
import com.example.mylibrary.LoopFW;
import com.example.mylibrary.Scene;
import com.example.sovereignsgate.scenes.MainMenuScene;
import com.example.sovereignsgate.scenes.StartS;

public class Main extends Core {



    public Scene StartS(){
        return new StartS(this);
    }
    //public Scene getStartScene(){
    //    return new MainMenuScene(this);
    //}
}