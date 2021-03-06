package ru.geekbrains.sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Ship;
import ru.geekbrains.math.Rect;
import ru.geekbrains.pool.BulletPool;
import ru.geekbrains.pool.ExplosionPool;

public class Enemy extends Ship {
    private static final float STARTED_VELOCITY = -0.5f;

    public Enemy(BulletPool bulletPool, ExplosionPool explosionPool, Rect worldBounds, Sound shootSound) {
        super(bulletPool, explosionPool, worldBounds, shootSound);
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        if(getTop()<worldBounds.getTop()){
            vel.set(velStart);
            bulletPos.set(pos.x, pos.y - getHalfHeight());
            autoShoot(delta);
        }

        if(getBottom()<=worldBounds.getBottom() || healthPoints <=0){
            destroy();
        }
    }

    public void set(
            TextureRegion[] regions,
            Vector2 velStart,
            TextureRegion bulletRegion,
            float bulletHeight,
            float bulletVelY,
            int bulletDamage,
            float reloadInterval,
            float height,
            int healthPoints,
            int damage,
            boolean giveBonus
    ){
        this.regions = regions;
        this.velStart.set(velStart);
        this.vel.set(0, STARTED_VELOCITY);
        this.bulletRegion = bulletRegion;
        this.bulletHeight = bulletHeight;
        this.bulletVelocity.set(0, bulletVelY);
        this.bulletDamage = bulletDamage;
        this.reloadInterval = reloadInterval;
        this.reloadTimer = reloadInterval;
        this.healthPoints = healthPoints;
        this.damage = damage;
        setHeightProportion(height);
        this.frame = 0;
        this.giveBonus = giveBonus;
    }

    public boolean isBulletCollision(Bullet bullet){
        return !(bullet.getRight() < getLeft()
                || bullet.getLeft()  > getRight()
                || bullet.getBottom() > getTop()
                || bullet.getTop() < pos.y
        );
    }
}
