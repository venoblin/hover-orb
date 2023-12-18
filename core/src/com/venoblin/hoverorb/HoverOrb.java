package com.venoblin.hoverorb;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import screens.GameScreen;
import screens.MainMenuScreen;

public class HoverOrb extends Game {

	private Stage stage;

	@Override
	public void create() {
		stage = new Stage(new StretchViewport(
				Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight()
		));
		Gdx.input.setInputProcessor(stage);
		goToMainMenu();
	}

	@Override
	public void render() {
		ScreenUtils.clear(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		screen.render(Gdx.graphics.getDeltaTime());
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
	
	@Override
	public void dispose() {
		stage.dispose();
	}

	public void goToGame() {
		setScreen(new GameScreen(this, stage));
	}

	public void goToMainMenu() {
		setScreen(new MainMenuScreen(this, stage));
	}
}
