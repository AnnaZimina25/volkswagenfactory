package ru.zimina.volkswagenfactory;

public class Car {

    CarBody body;
    Engine engine;
    Chassis chassis;
    Long vinNumber;
    DetailModel model;

    public Car(CarBody body, Engine engine, Chassis chassis, long vinNumber) {

        this.body = body;
        this.engine = engine;
        this.chassis = chassis;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model=" + model +
                '}';
    }
}
