package ru.zimina.volkswagenfactory;

public class Polo extends Car {

    static final DetailModel model = DetailModel.POLO;

    public Polo(CarBody body, Engine engine, Chassis chassis, long vinNumber) {
        super(body, engine, chassis, vinNumber, model);
    }
}
