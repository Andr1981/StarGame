package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.ScaledButton;
import ru.geekbrains.math.Rect;


public class ButtonPlay extends ScaledButton {

    private static final float MARGIN = 0.025f;

    public ButtonPlay(TextureAtlas atlas) {
        super(atlas.findRegion("btPlay"));
    }

    @Override
    public void action() {
        screenController.setGameScreen();
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.1f);
    }
}
