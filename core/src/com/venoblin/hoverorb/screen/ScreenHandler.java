package com.venoblin.hoverorb.screen;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.venoblin.hoverorb.HoverOrb;

public class ScreenHandler extends ScreenAdapter {
    private final HoverOrb game;
    private final Stage stage;

    public ScreenHandler(HoverOrb game, Stage stage) {
        this.game = game;
        this.stage = stage;
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