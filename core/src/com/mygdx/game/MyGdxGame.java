package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	int clicks = 0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("gift.png");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);

		float x = Gdx.input.getX()- img.getWidth()/2f;
		float y = Gdx.graphics.getHeight() - Gdx.input.getY()- img.getHeight()/2f;

		batch.begin();

		if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
			clicks +=1;
		}
		String text = "Вы нажали левую кнопку мыши " + clicks + " раз!";
		Gdx.graphics.setTitle(text);

		batch.draw(img, x, y);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
