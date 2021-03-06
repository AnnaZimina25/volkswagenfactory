package ru.zimina.volkswagenfactory;

import static ru.zimina.volkswagenfactory.Main.logger;

public abstract class Car {

    protected CarBody body;
    protected Engine engine;
    protected Chassis chassis;
    protected Long vinNumber;

    public abstract void printModel();

}
