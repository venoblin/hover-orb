package com.venoblin.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.venoblin.hoverorb.HoverOrb;

public class MainMenuScreen extends ScreenAdapter implements Screen {
    private final HoverOrb game;
    private final Stage stage;
    private final Table table;
    private final TextButton startBtn;

    public MainMenuScreen(final HoverOrb game, Stage stage) {
        this.game = game;
        this.stage = stage;

        table = new Table();
        table.setFillParent(true);

        startBtn = new TextButton("Start", new Skin(Gdx.files.internal("skins/uiskin.json")));
        startBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.goToGame();
            }
        });

        table.add(startBtn).size(300, 200);

        stage.addActor(table);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        stage.getRoot().removeActor(table);
    }

    @Override
    public void dispose() {
        stage.dispose();
        game.dispose();
    }
}