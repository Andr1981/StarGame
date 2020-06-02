package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.Selector;
import ru.geekbrains.screen.ScreenController;

public class SelectorMusic extends Selector {
    private ScreenController screenController;

    public SelectorMusic(TextureAtlas atlas, ScreenController screenController) {
        super(atlas);
        this.screenController = screenController;
        this.switchedOn = screenController.isMusic();
        changeFrame();
    }

    @Override
    public void action() {
        screenController.setMusic(switchedOn);
    }
}
