package com.venoblin.hoverorb;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

import ball.BallActor;

public class HoverOrb extends ApplicationAdapter {

	private Stage stage;
	private BallActor ball;
	private Texture img;

	@Override
	public void create () {
		ball = new BallActor(new Texture("ball.png"));
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
	}
	
	@Override
	public void dispose () {
		img.dispose();
	}
}
