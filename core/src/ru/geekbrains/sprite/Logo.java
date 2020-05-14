package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;
import ru.geekbrains.screen.ScreenController;

public class Logo extends Sprite {
    private Vector2 newPos, velocity, common;

    public Logo(Texture texture, ScreenController screenController) {
        super(new TextureRegion(texture, 30,30,200,180), screenController);
        newPos = new Vector2(pos);
        velocity = new Vector2(0,0);
        common = new Vector2(0,0);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.2f);
        this.pos.set(worldBounds.pos);
    }

    @Override
    public void draw(SpriteBatch batch) {
        if (common.set(newPos).sub(pos).len2() > velocity.len2())
            pos.add(velocity);
        else{
            pos.set(newPos);
            velocity.setZero();
            common.setZero();
        }

        super.draw(batch);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        newPos = touch;
        common = newPos.cpy().sub(pos);
        velocity.set(common).setLength(0.01f);
        return false;
    }
}
