package com.venoblin.hoverorb.screen;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.venoblin.hoverorb.HoverOrb;
import com.venoblin.hoverorb.ui.UiHandler;

public class ScreenHandler extends ScreenAdapter {
    protected final HoverOrb game;
    protected final Stage stage;
    protected final UiHandler ui;

    public ScreenHandler(HoverOrb game, Stage stage) {
        this.game = game;
        this.stage = stage;
        ui = new UiHandler();
        stage.addActor(ui);
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
        ui.clear();
    }

    @Override
    public void pause() {
        super.pause();
        game.goToPauseMenu();
    }

    @Override
    public void resume() {
        super.resume();
        game.goToGame();
    }

    public void start() {
        game.goToGame();
    }

    public void mainMenu() {
        game.goToMainMenu();
    }

    public void themeStore() {
        game.goToThemeStore();
    }

    public void end(int score) {
        game.goToGameOverMenu(score);
    }

    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
        game.dispose();
    }
}