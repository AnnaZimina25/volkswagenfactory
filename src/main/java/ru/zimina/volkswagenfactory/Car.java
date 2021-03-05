package ru.zimina.volkswagenfactory;

public class Car {

    protected CarBody body;
    protected Engine engine;
    protected Chassis chassis;
    protected Long vinNumber;
    protected DetailModel model;

    public Car(CarBody body, Engine engine, Chassis chassis, long vinNumber, DetailModel model) {

        this.body = body;
        this.engine = engine;
        this.chassis = chassis;
        this.vinNumber = vinNumber;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "body=" + body +
                ", engine=" + engine +
                ", chassis=" + chassis +
                ", vinNumber=" + vinNumber +
                ", model=" + model +
                '}';
    }

    public String toStringModel() {
        return model.name();
    }

}
