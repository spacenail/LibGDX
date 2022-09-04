package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	MyAnimation myAnimation;
	int borderLeft;
	int borderRight;
	int stepX;
	boolean direction;

	@Override
	public void create () {
		batch = new SpriteBatch();
		myAnimation = new MyAnimation("sprites.png");
		borderRight = Gdx.graphics.getWidth() - myAnimation.getFrame().getRegionWidth();
		borderLeft = myAnimation.getFrame().getRegionWidth() / 2;
		direction = true;
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		myAnimation.setTime(Gdx.graphics.getDeltaTime());
		TextureRegion textureRegion = myAnimation.getFrame();
		batch.draw(textureRegion, addStepX(textureRegion) ,0);
		batch.end();
	}

	private int addStepX(TextureRegion textureRegion) {
		flip(textureRegion);
		checkBorder();

		if (stepX <= borderRight && direction){
			stepX++;
		}else if (stepX <= borderRight && !direction) {
		 	stepX--;
		}

		return stepX;
	}

	private void checkBorder() {
		if(stepX == borderRight){
			direction = false;
		}
		if(stepX == borderLeft){
			direction = true;
		}
	}

	private void flip(TextureRegion textureRegion) {
		if(direction){
			if(!textureRegion.isFlipX()) {
				textureRegion.flip(true,false);}
		}else {
			if(textureRegion.isFlipX()) {
				textureRegion.flip(true,false);}
		}
	}

	@Override
	public void dispose(){
		batch.dispose();
		myAnimation.dispose();
	}
}
