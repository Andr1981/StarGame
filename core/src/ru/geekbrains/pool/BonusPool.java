package ru.geekbrains.pool;

import ru.geekbrains.base.SpritesPool;
import ru.geekbrains.screen.ScreenController;
import ru.geekbrains.sprite.Bonus;

public class BonusPool extends SpritesPool <Bonus> {
    public BonusPool(ScreenController screenController) {
        super(screenController);
    }

    @Override
    protected Bonus newObject() {
        Bonus newBonus = new Bonus();
        newBonus.setScreenController(screenController);
        return newBonus;
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
