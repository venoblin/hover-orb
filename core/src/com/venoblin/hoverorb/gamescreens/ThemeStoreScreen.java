package com.venoblin.hoverorb.gamescreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.venoblin.hoverorb.HoverOrb;
import com.venoblin.hoverorb.screen.ScreenHandler;

public class ThemeStoreScreen extends ScreenHandler {
    private final TextButton okBtn;

    public ThemeStoreScreen(final HoverOrb game, final Stage stage) {
        super(game, stage);

        okBtn = new TextButton("Ok", new Skin(Gdx.files.internal("skins/uiskin.json")));
        okBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                mainMenu();
            }
        });

        ui.add(okBtn).size(200, 80);
    }
}