package ru.geekbrains;

import com.badlogic.gdx.Game;
import ru.geekbrains.screen.ScreenController;

public class StarGame extends Game {

    @Override
    public void create() {

        new ScreenController(this);
    }
}

