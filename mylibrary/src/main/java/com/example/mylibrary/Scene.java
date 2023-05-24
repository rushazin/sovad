package com.example.mylibrary;

public abstract class Scene {
    protected Core core;
    public int sceneWidth;
    public int sceneHeight;
    public Graphics graphics;

    public Scene(Core core) {
        this.core = core;
        graphics = core.getGraphics();
        sceneHeight = core.getGraphics().getHeight();
        sceneWidth = core.getGraphics().getWidth();
    }

    public abstract void update();
    public abstract void drawing();
    public abstract void pause();
    public abstract void resume();
    public abstract void dispose();
}

