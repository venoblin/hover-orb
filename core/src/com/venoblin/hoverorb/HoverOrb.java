package com.venoblin.hoverorb;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import actors.BallActor;

public class HoverOrb extends ApplicationAdapter {

	private Stage stage;
	private BallActor ball;
	private Texture ballTexture;

	@Override
	public void create() {
		stage = new Stage(new StretchViewport(
				Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight()
		));
		Gdx.input.setInputProcessor(stage);
		ballTexture = new Texture("ball.png");
		ball = new BallActor(ballTexture);
		stage.addActor(ball);
	}

	@Override
	public void render() {
		ScreenUtils.clear(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
	
	@Override
	public void dispose() {
		ballTexture.dispose();
		stage.dispose();
	}
}
