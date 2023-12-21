package com.venoblin.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.venoblin.actors.BallActor;
import com.venoblin.hoverorb.HoverOrb;
import com.venoblin.ui.UI;

public class GameScreen extends ScreenAdapter {
    private final HoverOrb game;
    private final Stage stage;
    private final UI ui;
    private final Label scoreLabel;
    private final TextButton pauseButton;
    private final BallActor ball;
    private final Texture ballTexture;

    public GameScreen(HoverOrb game, Stage stage) {
        this.game = game;
        this.stage = stage;

        ballTexture = new Texture("ball.png");
        ball = new BallActor(ballTexture);

        ui = new UI();
        ui.top();
        ui.left();
        ui.setPosition(100, Gdx.graphics.getHeight() - 200);
        ui.setSize(Gdx.graphics.getWidth(), 200);

        scoreLabel = new Label("0", new Skin(Gdx.files.internal("skins/uiskin.json")));
        scoreLabel.setFontScale(4);

        pauseButton = new TextButton("Pause", new Skin(Gdx.files.internal("skins/uiskin.json")));
        pauseButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                pause();
            }
        });

        ui.add(scoreLabel).expandX();
        ui.add(pauseButton).expandX();

        stage.addActor(ui);
        stage.addActor(ball);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (ball.isGameOver()) {
            game.goToMainMenu();
        }

        if (ball.isGameLive()) {
            ui.removeActor(pauseButton);
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        game.goToMainMenu();
    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        stage.getRoot().removeActor(ball);
        ui.clear();
    }

    @Override
    public void dispose() {
        ballTexture.dispose();
        stage.dispose();
        game.dispose();
    }
}