package ru.zimina.volkswagenfactory;

import static ru.zimina.volkswagenfactory.Main.logger;

public class Jetta extends Car {

    static final DetailModel model = DetailModel.JETTA;

    public Jetta(CarBody body, Engine engine, Chassis chassis, long vinNomber) {

        this.body = body;
        this.engine = engine;
        this.chassis = chassis;
        this.vinNumber = vinNomber;
        logger.info("Создан объект класса Jetta");
    }

    @Override
    public void printModel() {
        System.out.println(model);
    }

    @Override
    public String toString() {
        return "Jetta{" +
                "body=" + body.toString() +
                ", engine=" + engine.toString() +
                ", chassis=" + chassis.toString() +
                ", vinNumber=" + vinNumber.toString() +
                ", model=" + model.name() +
                '}';
    }
}
