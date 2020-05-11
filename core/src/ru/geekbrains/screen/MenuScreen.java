package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;

public class MenuScreen extends BaseScreen {
    private Texture backGround;
    private Texture badlogic;
    private Vector2 posBadlogic, newPosBadlogic, velBadlogic, deltaBadlogic;

    @Override
    public void show() {
        super.show();
        backGround = new Texture("background.jpg");
        badlogic = new Texture("badlogic.jpg");
        posBadlogic = new Vector2(10, 10);
        newPosBadlogic = new Vector2(posBadlogic);
        velBadlogic = new Vector2(0, 0);
        deltaBadlogic = new Vector2(0, 0);

    }


    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(backGround, 0,0);
        if (!stopMove())
            posBadlogic.add(velBadlogic);
        batch.draw(badlogic, posBadlogic.x, posBadlogic.y, 150, 150);
        batch.end();
    }

    private void calcNewVelocity() {
        velBadlogic.set(newPosBadlogic.x - posBadlogic.x, newPosBadlogic.y - posBadlogic.y).nor();
    }

    private boolean stopMove() {
        deltaBadlogic.set(newPosBadlogic.x - posBadlogic.x, newPosBadlogic.y - posBadlogic.y);
        if (velBadlogic.len2() > 0 && velBadlogic.len2() >= deltaBadlogic.len2()) {
            posBadlogic.set(newPosBadlogic);
            velBadlogic.set(0, 0);
            deltaBadlogic.set(0, 0);
            return true;
        }
        if (deltaBadlogic.len2() > 0)
            velBadlogic.scl(1.1f);
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        newPosBadlogic.set(screenX, Gdx.graphics.getHeight() - screenY);
        calcNewVelocity();
        return false;
    }

    @Override
    public void dispose() {
        super.dispose();
        backGround.dispose();
        badlogic.dispose();
    }
}
