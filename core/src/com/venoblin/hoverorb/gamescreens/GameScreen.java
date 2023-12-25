package com.venoblin.hoverorb.gamescreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.venoblin.hoverorb.HoverOrb;
import com.venoblin.hoverorb.actors.BallActor;
import com.venoblin.hoverorb.screen.ScreenHandler;

public class GameScreen extends ScreenHandler {
    private final Label scoreLabel;
    private final TextButton pauseBtn;
    private final BallActor ball;
    private final Texture ballTexture;
    int score = 0;

    public GameScreen(final HoverOrb game, final Stage stage) {
        super(game, stage);

        ballTexture = new Texture("ball.png");
        ball = new BallActor(ballTexture);

        scoreLabel = new Label(String.valueOf(score), new Skin(Gdx.files.internal("skins/uiskin.json")));
        scoreLabel.setFontScale(4);
        pauseBtn = new TextButton("Pause", new Skin(Gdx.files.internal("skins/uiskin.json")));
        pauseBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                pause();
            }
        });

        ui.top();
        ui.left();
        ui.setPosition(100, Gdx.graphics.getHeight() - 200);
        ui.setSize(Gdx.graphics.getWidth(), 200);

        ui.add(scoreLabel).expandX();
        ui.add(pauseBtn).size(200, 80).expandX();

        stage.addActor(ball);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        if (ball.isGameOver()) {
            end(score);
        }

        if (ball.isGameLive() && ball.isTouched()) {
            score++;
            scoreLabel.setText(String.valueOf(score));
        }

        if (ball.isGameLive()) {
            ui.removeActor(pauseBtn);
        }
    }

    @Override
    public void hide() {
        super.hide();
        stage.getRoot().removeActor(ball);
        score = 0;
    }

    @Override
    public void dispose() {
        super.dispose();
        ballTexture.dispose();
    }
}