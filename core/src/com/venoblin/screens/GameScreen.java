package com.venoblin.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.venoblin.actors.BallActor;
import com.venoblin.hoverorb.HoverOrb;
import com.venoblin.ui.UI;

public class GameScreen extends ScreenAdapter {
    private final HoverOrb game;
    private final Stage stage;
    private final UI ui;
    private final Label scoreLabel;
    private final BallActor ball;
    private final Texture ballTexture;

    public GameScreen(HoverOrb game, Stage stage) {
        this.game = game;
        this.stage = stage;

        ballTexture = new Texture("ball.png");
        ball = new BallActor(ballTexture);

        ui = new UI();
        ui.setFillParent(true);

        scoreLabel = new Label("0", new Skin(Gdx.files.internal("skins/uiskin.json")));

        ui.add(scoreLabel);

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