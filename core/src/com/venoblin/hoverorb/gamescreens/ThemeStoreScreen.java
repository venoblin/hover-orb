package com.venoblin.hoverorb.gamescreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.venoblin.hoverorb.HoverOrb;
import com.venoblin.hoverorb.screen.ScreenHandler;

import java.util.ArrayList;

public class ThemeStoreScreen extends ScreenHandler {
    private final Table ballsTable;
    private final TextButton okBtn;
    private final ArrayList<Texture> ballsTexturesArr;

    public ThemeStoreScreen(final HoverOrb game, final Stage stage) {
        super(game, stage);

        ballsTable = new Table();
        ballsTexturesArr = new ArrayList<Texture>();

        okBtn = new TextButton("Ok", new Skin(Gdx.files.internal("skins/uiskin.json")));
        okBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                mainMenu();
            }
        });

        FileHandle ballsHandle = Gdx.files.internal("balls");
        if (ballsHandle.isDirectory()) {
            FileHandle[] balls = ballsHandle.list();

            for (FileHandle ball : balls) {
                final Texture ballTexture = new Texture(ball);

                ballsTexturesArr.add(ballTexture);
                Image ballImg = new Image(ballTexture);
                ballImg.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        game.updateBallTexture(ballTexture);
                    }
                });
                ballsTable.add(ballImg);
            }
        }

        ui.setFillParent(true);

        ui.add(ballsTable);
        ui.row();
        ui.add(okBtn).size(200, 80);
    }

    @Override
    public void dispose() {
        super.dispose();

        for (Texture ball : ballsTexturesArr) {
            ball.dispose();
        }
    }
}