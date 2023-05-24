package com.example.sovereignsgate.scenes;

import android.graphics.Color;
import com.example.mylibrary.Core;
import com.example.mylibrary.Scene;

public class GameScene extends Scene {
    private GameState gameState;

    public int score = 0;
    //public int bestscore = 0;

    MainMenuScene r = new MainMenuScene(core);

    Settings settings = new Settings(core);

    enum GameState{
        READY, RUNNING, PAUSE, GAME_OVER
    }

    public GameScene(Core core) {
        super(core);
        gameState = GameState.READY;
    }



    @Override
    public void update() {
        if (gameState == GameState.READY){
            updateStateReady();
        }
        if (gameState == GameState.RUNNING){
            updateStateRunning();
        }
        if (gameState == GameState.PAUSE){
            updateStatePause();
        }
        if (gameState == GameState.GAME_OVER){
            updateStateGameOver();
        }
    }
    @Override
    public void drawing() {
        if (gameState == GameState.READY){
            drawingStateReady();
        }
        if (gameState == GameState.RUNNING){
            drawingStateRunning();
        }
        if (gameState == GameState.PAUSE){
            drawingStatePause();
        }
        if (gameState == GameState.GAME_OVER){
            drawingStateGameOver();
        }
    }



    public int i = 0;
    private void updateStateReady(){
        i++;
        if(i >= 180){
            i = 0;
            gameState = GameState.RUNNING;
        }
    }
    private void drawingStateReady(){
        graphics.clear(Color.rgb(255, 191, 0));
        graphics.drawText("Скорость:", 20, 1800, Color.WHITE, 130, null, null);

        if(core.speed == 1){
            graphics.drawText("очень медленно",20,   1900, Color.WHITE, 100, null, null);
        }
        if(core.speed == 2){
            graphics.drawText("медленно",      20,   1900, Color.WHITE, 100, null, null);
        }
        if(core.speed == 3){
            graphics.drawText("средне",        20,   1900, Color.WHITE, 100, null, null);
        }
        if(core.speed == 4){
            graphics.drawText("быстро",        20,   1900, Color.WHITE, 100, null, null);
        }
        if(core.speed == 5){
            graphics.drawText("очень быстро",  20,   1900, Color.WHITE, 100, null, null);
        }


        if(i >= 0 && i < 60){
            graphics.drawText("3", 500, 1000, Color.WHITE, 200, null, null);
        }
        if(i >= 60 && i < 120){
            graphics.drawText("2", 500, 1000, Color.WHITE, 200, null, null);
        }
        if(i >= 120 && i < 180){
            graphics.drawText("1", 500, 1000, Color.WHITE, 200, null, null);
        }
        if(i >= 180){
            graphics.drawText("GO!", 450, 1000, Color.WHITE, 200, null, null);
        }

    }



    private void updateStatePause(){
        if(core.touch_listen().getTouchUp(300,300, 100, 60)){
            gameState = GameState.PAUSE;
        }
        if(core.touch_listen().getTouchUp(300,450, 100, 60)){
            core.restart = 0;
            core.setScene(new StartS(core));
        }
        if(core.touch_listen().getTouchUp(300,500, 100, 60)){
            core.restart = 180;
            core.setScene(new GameScene(core));
        }

    }
    private void drawingStatePause(){
        graphics.clear(Color.BLACK);
        graphics.drawText("Play",     300, 300, Color.WHITE, 50, null, null);
        graphics.drawText("Menu",     300, 450, Color.WHITE, 50, null, null);
        graphics.drawText("Restart",  300, 500, Color.WHITE, 50, null, null);
        graphics.drawText("Pause",    300, 700, Color.WHITE, 80, null, null);
    }

    public int line1 = 0;
    public int line2 = -216*3;
    public int line3 = -216*6;
    public int line4 = -216*9;
    public int line5 = -216*12;

    public int playerX = 540;
    public int playerY = 1800;

    public int startX1 = 0;
    public int startX2 = 216;
    public int startX3 = 216*2;
    public int startX4 = 216*3;
    public int startX5 = 216*4;

    public int stopX1 = 216;
    public int stopX2 = 216*2;
    public int stopX3 = 216*3;
    public int stopX4 = 216*4;
    public int stopX5 = 216*5;

    public int[] a1 = new int[6];
    public int[] a2 = new int[6];
    public int[] a3 = new int[6];
    public int[] a4 = new int[6];
    public int[] a5 = new int[6];
    public int[] a0 = new int[6];
    public int p = 3;

    //line1/graphics.drawGameLine(startX1, line1, stopX1, line1, Color.BLACK);
    //line2/graphics.drawGameLine(startX2, line1, stopX2, line1, Color.BLACK);
    //line3/graphics.drawGameLine(startX3, line1, stopX3, line1, Color.BLACK);
    //line4/graphics.drawGameLine(startX4, line1, stopX4, line1, Color.BLACK);
    //line5/graphics.drawGameLine(startX5, line1, stopX5, line1, Color.BLACK);
    private void updateStateRunning(){


            score++;
            graphics.person(playerX, playerY);


            line1 += 6*core.speed;
            line2 += 6*core.speed;
            line3 += 6*core.speed;
            line4 += 6*core.speed;
            line5 += 6*core.speed;

        if(core.touch_listen().getTouchUp(540,2280, 540 , 2000)) {
            if (playerX <= 864) {
                playerX = playerX + 216;
                p++;
            }
        }
        if(core.touch_listen().getTouchUp(0,2280, 540, 2000)){
            if (playerX >= 216) {
                playerX = playerX - 216;
                p--;
            }
        }

        if(core.touch_listen().getTouchUp(50,100, 100, 100)){
            gameState = GameState.PAUSE;
        }
        //"\n"
        if((playerY -100 - (line1 - 20) <= 0 && a1[p] == 1 && line1 < playerY)
                || (playerY -100 - (line2 - 20) <= 0 && a2[p] == 1 && line2 < playerY)
                    || (playerY -100 - (line3 - 20) <= 0 && a3[p] == 1 && line3 < playerY)
                        || (playerY -100 - (line4 - 20) <= 0 && a4[p] == 1 && line4 < playerY)
                            || (playerY -100 - (line5 - 20) <= 0 && a5[p] == 1) && line5 < playerY){
            gameState = GameState.GAME_OVER;
        }



            graphics.drawGameLine(startX1, line1, stopX1, line1, Color.BLACK);
            graphics.drawGameLine(startX3, line1, stopX3, line1, Color.BLACK);

            a1[1] = 1;
            a1[3] = 1;

            if(line1 == 2281){
                line1 = 0;
                a1 = a0;
            }

            graphics.drawGameLine(startX1, line2, stopX1, line2, Color.BLACK);
            graphics.drawGameLine(startX2, line2, stopX2, line2, Color.BLACK);
            graphics.drawGameLine(startX4, line2, stopX4, line2, Color.BLACK);

            a2[1] = 1;
            a2[2] = 1;
            a2[4] = 1;

            if(line2 == 2281){
                line2 = 0;
            }

            graphics.drawGameLine(startX1, line3, stopX1, line3, Color.BLACK);
            graphics.drawGameLine(startX2, line3, stopX2, line3, Color.BLACK);
            graphics.drawGameLine(startX3, line3, stopX3, line3, Color.BLACK);
            graphics.drawGameLine(startX5, line3, stopX5, line3, Color.BLACK);

            a3[1] = 1;
            a3[2] = 1;
            a3[3] = 1;
            a3[5] = 1;

            if(line3 == 2281){
                line3 = 0;
            }

            graphics.drawGameLine(startX3, line4, stopX3, line4, Color.BLACK);
            graphics.drawGameLine(startX2, line4, stopX2, line4, Color.BLACK);
            graphics.drawGameLine(startX4, line4, stopX4, line4, Color.BLACK);

            a4[2] = 1;
            a4[3] = 1;
            a4[4] = 1;

            if(line4 == 2281){
                line4 = 0;
            }

            graphics.drawGameLine(startX1, line5, stopX1, line5, Color.BLACK);
            graphics.drawGameLine(startX2, line5, stopX2, line5, Color.BLACK);
            graphics.drawGameLine(startX4, line5, stopX4, line5, Color.BLACK);

            a5[1] = 1;
            a5[2] = 1;
            a5[4] = 1;

            if(line5 == 2281){
                line5 = 0;
            }




        }

    private void drawingStateRunning(){
        graphics.clear(Color.rgb(255, 191, 0));
        graphics.drawText("Score",          50,    150,    Color.BLACK, 75, null, null);
        graphics.drawText(String.valueOf(score), 50,   210,    Color.BLACK, 75, null, null);
        graphics.drawText("Pause",           50,   100,    Color.BLACK, 75, null, null);

    }


    private void updateStateGameOver(){
        if(core.touch_listen().getTouchUp(300,1000, 400, 120)){
            core.restart = 0;
            core.setScene(new StartS(core));
        }
        if(core.touch_listen().getTouchUp(300,1150, 400, 120)){
            core.restart = 180;
            core.setScene(new GameScene(core));
        }

    }
    private void drawingStateGameOver(){
        graphics.clear(Color.BLACK);
        //if (score > bestscore){
        //    bestscore = score;
        //    }
        //String strBestScore = String.valueOf(bestscore);
        String strScore = String.valueOf(score);
        graphics.drawText("DEATH",     50,  200 , Color.WHITE, 130, null, null);
        graphics.drawText("SCORE",     50,  350, Color.WHITE, 100, null, null);
        graphics.drawText(strScore,         50, 450, Color.WHITE, 100, null, null);
        //graphics.drawText("BEST SCORE",50 , 550, Color.WHITE, 100, null, null);
        //graphics.drawText(strBestScore,     50,  650, Color.WHITE, 100, null, null);


        graphics.drawText("Menu",     300, 1000, Color.WHITE, 110, null, null);
        graphics.drawText("Restart",  300, 1150, Color.WHITE, 110, null, null);

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
