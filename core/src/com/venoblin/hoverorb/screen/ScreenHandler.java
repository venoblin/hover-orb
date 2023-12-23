package com.venoblin.hoverorb.screen;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.venoblin.hoverorb.HoverOrb;
import com.venoblin.hoverorb.ui.UiHandler;

public class ScreenHandler extends ScreenAdapter {
    private final HoverOrb game;
    private final Stage stage;
    private final UiHandler ui;

    public ScreenHandler(HoverOrb game, Stage stage) {
        this.game = game;
        this.stage = stage;
        ui = new UiHandler();
    }

    public UiHandler uiHandler() {
        return ui;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
        game.dispose();
    }
}