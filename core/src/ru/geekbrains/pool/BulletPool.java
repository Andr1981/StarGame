package ru.geekbrains.pool;


import ru.geekbrains.base.SpritesPool;
import ru.geekbrains.screen.ScreenController;
import ru.geekbrains.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    public BulletPool(ScreenController screenController) {
        super(screenController);
    }

    @Override
    protected Bullet newObject() {
        Bullet newBullet = new Bullet();
        newBullet.setScreenController(screenController);
        return newBullet;
    }
}
