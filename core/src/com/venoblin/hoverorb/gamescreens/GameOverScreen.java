package com.venoblin.hoverorb.gamescreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.venoblin.hoverorb.HoverOrb;
import com.venoblin.hoverorb.preferences.GamePreferences;
import com.venoblin.hoverorb.screen.ScreenHandler;

public class GameOverScreen extends ScreenHandler {
    private final TextButton retryBtn;
    private final TextButton mainMenuBtn;
    private final Label scoreLabel;
    private final Label highScoreLabel;
    private final int fontSize = 6;

    public GameOverScreen(final HoverOrb game, Stage stage, int score) {
        super(game, stage);
        int topScore = GamePreferences.loadHighScore();

        highScoreLabel = new Label("High Score: " + String.valueOf(topScore), new Skin(Gdx.files.internal("skins/uiskin.json")));
        highScoreLabel.setFontScale(fontSize);
        scoreLabel = new Label("Score: " + String.valueOf(score), new Skin(Gdx.files.internal("skins/uiskin.json")));
        scoreLabel.setFontScale(fontSize);
        retryBtn = new TextButton("Retry", new Skin(Gdx.files.internal("skins/uiskin.json")));
        retryBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                resume();
            }
        });
        mainMenuBtn = new TextButton("Main Menu", new Skin(Gdx.files.internal("skins/uiskin.json")));
        mainMenuBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                mainMenu();
            }
        });

        ui.setFillParent(true);
        if (score > topScore) {
            GamePreferences.setHighScore(score);
            highScoreLabel.setText("New High Score: " + String.valueOf(score));
            ui.add(highScoreLabel);
        } else {
            ui.add(highScoreLabel);
            ui.row();
            ui.add(scoreLabel);
        }
        ui.row();
        ui.add(retryBtn).size(200, 80);
        ui.add(mainMenuBtn).size(200, 80);
    }
}