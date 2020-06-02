package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.Selector;
import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class SelectorField extends Sprite {
    public SelectorField(TextureAtlas atlas) {
        super(atlas.findRegion("option"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.24f);
    }


    public void updatePosEffects(Selector selector){

    }

    public void updatePosMusic(Selector selector){

    }
}
