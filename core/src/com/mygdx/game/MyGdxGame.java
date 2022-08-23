package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	MyAnimation myAnimation;
	float time;

	@Override
	public void create () {
		batch = new SpriteBatch();
		myAnimation = new MyAnimation("sprites.png");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		time += Gdx.graphics.getDeltaTime();
		batch.draw(myAnimation.getKeyFrame(time), 0 ,0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		myAnimation.dispose();
	}
}
