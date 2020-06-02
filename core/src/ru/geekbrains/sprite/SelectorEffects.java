package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.Selector;
import ru.geekbrains.screen.ScreenController;

public class SelectorEffects extends Selector {
    private ScreenController screenController;

    public SelectorEffects(TextureAtlas atlas, ScreenController screenController) {
        super(atlas);
        this.screenController = screenController;
        this.switchedOn = screenController.isEffects();
        changeFrame();
    }

    @Override
    public void action() {
        screenController.setEffects(switchedOn);
    }
}
