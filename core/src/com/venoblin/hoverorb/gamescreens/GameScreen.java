package com.venoblin.hoverorb.gamescreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.venoblin.hoverorb.HoverOrb;
import com.venoblin.hoverorb.actors.BallActor;
import com.venoblin.hoverorb.ui.UiHandler;

public class GameScreen extends ScreenAdapter {
    private final HoverOrb game;
    private final Stage stage;
    private final UiHandler ui;
    private final Label scoreLabel;
    private final TextButton pauseBtn;
    private final BallActor ball;
    private final Texture ballTexture;

    public GameScreen(final HoverOrb game, Stage stage) {
        this.game = game;
        this.stage = stage;

        ballTexture = new Texture("ball.png");
        ball = new BallActor(ballTexture);

        ui = new UiHandler();
        ui.top();
        ui.left();
        ui.setPosition(100, Gdx.graphics.getHeight() - 200);
        ui.setSize(Gdx.graphics.getWidth(), 200);

        scoreLabel = new Label("0", new Skin(Gdx.files.internal("skins/uiskin.json")));
        scoreLabel.setFontScale(4);
        pauseBtn = new TextButton("Pause", new Skin(Gdx.files.internal("skins/uiskin.json")));
        pauseBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                pause();
            }
        });

        ui.add(scoreLabel).expandX();
        ui.add(pauseBtn).expandX();

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
            ui.removeActor(pauseBtn);
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        game.goToPauseMenu();
    }

    @Override
    public void resume() {
        game.goToGame();
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