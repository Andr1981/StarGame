package ru.geekbrains.pool;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.SpritesPool;
import ru.geekbrains.screen.ScreenController;
import ru.geekbrains.sprite.Explosion;

public class ExplosionPool extends SpritesPool <Explosion> {
    private TextureAtlas atlas;
    private Sound explosionSound;

    public ExplosionPool(TextureAtlas atlas, ScreenController screenController) {
        super(screenController);
        this.atlas = atlas;
        explosionSound = Gdx.audio.newSound(Gdx.files.internal("sounds/boom.mp3"));
    }

    @Override
    protected Explosion newObject() {
        Explosion newExplosion = new Explosion(atlas, explosionSound);
        newExplosion.setScreenController(screenController);
        return newExplosion;
    }

    @Override
    public void dispose() {
        super.dispose();
        explosionSound.dispose();
    }
}
