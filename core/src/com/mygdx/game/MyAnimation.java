package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class MyAnimation {
    private Texture texture;
    private TextureRegion[][] regions0;
    private TextureRegion[] walkRegions;
    private Animation<TextureRegion> animation;

    public MyAnimation(String pathToImage) {
        texture = new Texture(pathToImage);
        TextureRegion region0 = new TextureRegion(texture);

        int column = region0.getRegionWidth() / 10;
        int line = region0.getRegionHeight() / 10;
        regions0 = region0.split(column,line);
        walkRegions = new TextureRegion[8];
        for (int i = 0; i < 8; i++){
            walkRegions[i] = regions0[6][i];
        }
        animation = new Animation<>(1f / 10, walkRegions);
        animation.setPlayMode(Animation.PlayMode.LOOP);
    }

    public void dispose() {
        texture.dispose();
    }

    public TextureRegion getKeyFrame(float deltaTime) {
        return animation.getKeyFrame(deltaTime);
    }
}
