package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;


public class MainShip extends Sprite {

    private static final float MARGIN = 0.1f;
    private static final float VELOCITY = 0.01f;
    private float newX;
    private float newY;
    private Rect worldBounds;

    public MainShip(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship").split(atlas.findRegion("main_ship").getRegionWidth() / 2, atlas.findRegion("main_ship").getRegionHeight())[0]);
    }


    @Override
    public void update(float delta) {
        if ((newX - pos.x) * (newX - pos.x) > VELOCITY * VELOCITY) {
            if (newX > pos.x)
                pos.set(pos.x + VELOCITY, pos.y);
            else
                pos.set(pos.x - VELOCITY, pos.y);
        } else {
            pos.set(newX, newY);
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.2f);
        setBottom(worldBounds.getBottom() + MARGIN);
        this.worldBounds = worldBounds;
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        newX = touch.x;
        newY = touch.y;
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        newX = pos.x;
        newY = pos.y;
        return false;
    }

    @Override
    public boolean touchDragged(Vector2 touch, int pointer) {
        return false;
    }

    public boolean keyDown(int keycode) {
        if (keycode == 22)
            newX = worldBounds.getRight();
        if (keycode == 20)
            newY = worldBounds.getBottom() + MARGIN;
        if (keycode == 19)
            newY = worldBounds.getHalfHeight() - MARGIN;
        else if (keycode == 21)
            newX = worldBounds.getLeft();
        return false;
    }

    public boolean keyUp(int keycode) {
        if (keycode == 22 || keycode == 21)
            newX = pos.x;
        return false;
    }


}
