package ru.zimina.volkswagenfactory;

public class Jetta extends Car {

    static final DetailModel model = DetailModel.JETTA;

    public Jetta(CarBody body, Engine engine, Chassis chassis) {
        super(body, engine, chassis);
    }
}
