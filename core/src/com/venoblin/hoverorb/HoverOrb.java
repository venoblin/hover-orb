package com.venoblin.hoverorb;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.venoblin.hoverorb.gamescreens.GameOverScreen;
import com.venoblin.hoverorb.gamescreens.GameScreen;
import com.venoblin.hoverorb.gamescreens.MainMenuScreen;
import com.venoblin.hoverorb.gamescreens.PauseScreen;
import com.venoblin.hoverorb.gamescreens.ThemeStoreScreen;
import com.venoblin.hoverorb.interfaces.GameInterface;

public class HoverOrb extends Game implements GameInterface {
	private Stage stage;
	private Texture ballTexture;

	@Override
	public void create() {
		ballTexture = new Texture("balls/ball_1.png");
		stage = new Stage(new StretchViewport(
				Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight()
		));
		Gdx.input.setInputProcessor(stage);
		goToMainMenu();
	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		screen.render(Gdx.graphics.getDeltaTime());
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
	
	@Override
	public void dispose() {
		stage.dispose();
		ballTexture.dispose();
	}

	@Override
	public void goToGame() {
		setScreen(new GameScreen(this, stage, ballTexture));
	}

	@Override
	public void goToMainMenu() {
		setScreen(new MainMenuScreen(this, stage));
	}

	@Override
	public void goToPauseMenu() {
		setScreen(new PauseScreen(this, stage));
	}

	@Override
	public void goToGameOverMenu(int score) {
		setScreen(new GameOverScreen(this, stage, score));
	}

	@Override
	public void goToThemeStore() {
		setScreen(new ThemeStoreScreen(this, stage));
	}
}
