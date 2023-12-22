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
    private final UI liveGameUi;
    private final UI pauseUi;
    private final Label scoreLabel;
    private final TextButton pauseBtn;
    private final TextButton resumeBtn;
    private final TextButton mainMenuBtn;
    private final BallActor ball;
    private final Texture ballTexture;

    public GameScreen(final HoverOrb game, Stage stage) {
        this.game = game;
        this.stage = stage;

        ballTexture = new Texture("ball.png");
        ball = new BallActor(ballTexture);

        liveGameUi = new UI();
        pauseUi = new UI();

        scoreLabel = new Label("0", new Skin(Gdx.files.internal("skins/uiskin.json")));
        scoreLabel.setFontScale(4);
        pauseBtn = new TextButton("Pause", new Skin(Gdx.files.internal("skins/uiskin.json")));
        pauseBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                pause();
            }
        });

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

        setToLiveGameUi();
        stage.addActor(ball);
    }

    private void setToPauseUi() {
        pauseUi.setFillParent(true);
        pauseUi.add(resumeBtn);
        pauseUi.add(mainMenuBtn);

        stage.addActor(pauseUi);
    }

    private void setToLiveGameUi() {
        liveGameUi.top();
        liveGameUi.left();
        liveGameUi.setPosition(100, Gdx.graphics.getHeight() - 200);
        liveGameUi.setSize(Gdx.graphics.getWidth(), 200);

        liveGameUi.add(scoreLabel).expandX();
        liveGameUi.add(pauseBtn).expandX();

        stage.addActor(liveGameUi);
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
            liveGameUi.removeActor(pauseBtn);
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        hide();
        setToPauseUi();
    }

    @Override
    public void resume() {
        hide();
        game.goToGame();
    }

    @Override
    public void hide() {
        stage.getRoot().removeActor(ball);
        liveGameUi.clear();
        pauseUi.clear();
    }

    @Override
    public void dispose() {
        ballTexture.dispose();
        stage.dispose();
        game.dispose();
    }
}