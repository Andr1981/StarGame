package ru.geekbrains;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StarGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Texture background;
    Sprite backgroundSprite;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        background = new Texture("background.jpg");
        backgroundSprite = new Sprite(background);
        backgroundSprite.setSize(700,500);
        backgroundSprite.setPosition(0,0);
    }

    @Override
    public void render() {
        batch.begin();
        backgroundSprite.draw(batch);
        batch.draw(img, 0, 0);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
