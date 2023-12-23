package com.venoblin.hoverorb.gamescreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.venoblin.hoverorb.HoverOrb;
import com.venoblin.hoverorb.screen.ScreenHandler;

public class MainMenuScreen extends ScreenHandler {

    private final TextButton startBtn;

    public MainMenuScreen(final HoverOrb game, Stage stage) {
        super(game, stage);

        ui.setFillParent(true);

        startBtn = new TextButton("Start", new Skin(Gdx.files.internal("skins/uiskin.json")));
        startBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                start();
            }
        });

        ui.add(startBtn);
    }
}