package com.venoblin.hoverorb;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class HoverOrb extends ApplicationAdapter {
	Texture img;
	
	@Override
	public void create () {
		img = new Texture("ball.jpg");
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
