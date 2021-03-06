package ru.zimina.volkswagenfactory;

import static ru.zimina.volkswagenfactory.Main.logger;

public class Polo extends Car {

    static final DetailModel model = DetailModel.POLO;

    public Polo(CarBody body, Engine engine, Chassis chassis, long vinNumber) {
        this.body = body;
        this.engine = engine;
        this.chassis = chassis;
        this.vinNumber = vinNumber;
        logger.trace("Создан объект класса Polo");
    }

    @Override
    public void printModel() {
        System.out.println(model);

    }

    @Override
    public String toString() {
        return "Polo{" +
                "body=" + body.toString() +
                ", engine=" + engine.toString() +
                ", chassis=" + chassis.toString() +
                ", vinNumber=" + vinNumber.toString() +
                ", model=" + model.name() +
                '}';
    }
}
