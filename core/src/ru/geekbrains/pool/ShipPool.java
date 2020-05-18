package ru.geekbrains.pool;


import ru.geekbrains.base.Ship;
import ru.geekbrains.base.SpritesPool;

public class ShipPool extends SpritesPool<Ship> {
    @Override
    protected Ship newObject() {
        return new Ship();
    }
}
