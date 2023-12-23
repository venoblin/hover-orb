package com.venoblin.hoverorb.gamescreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.venoblin.hoverorb.HoverOrb;
import com.venoblin.hoverorb.screen.ScreenHandler;

public class PauseScreen extends ScreenHandler {
    private final TextButton resumeBtn;
    private final TextButton mainMenuBtn;

    public PauseScreen(final HoverOrb game, Stage stage) {
        super(game, stage);

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
                mainMenu();
            }
        });

        ui.add(resumeBtn).size(200, 80);
        ui.add(mainMenuBtn).size(200, 80);
    }
}