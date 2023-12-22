package com.venoblin.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.venoblin.hoverorb.HoverOrb;
import com.venoblin.ui.UI;

public class PauseScreen extends ScreenAdapter {
    private  final UI ui;
    private final TextButton resumeBtn;
    private final TextButton mainMenuBtn;

    public PauseScreen(final HoverOrb game, Stage stage) {
        ui = new UI();
        ui.setFillParent(true);

        resumeBtn = new TextButton("Resume", new Skin(Gdx.files.internal("skins/uiskin.json")));
        resumeBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                resume();
            }
        });
        mainMenuBtn = new TextButton("Main Menu", new Skin(Gdx.files.internal("skins/uiskin.json")));
        mainMenuBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.goToMainMenu();
            }
        });

        ui.add(resumeBtn);
        ui.add(mainMenuBtn);

        stage.addActor(ui);
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {
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