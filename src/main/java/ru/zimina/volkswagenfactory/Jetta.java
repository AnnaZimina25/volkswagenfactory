package ru.zimina.volkswagenfactory;

public class Jetta extends Car {

    static final DetailModel model = DetailModel.JETTA;

    public Jetta(CarBody body, Engine engine, Chassis chassis, long vinNomber) {
        super(body, engine, chassis, vinNomber, model);
    }

}
