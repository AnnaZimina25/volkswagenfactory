package ru.zimina.volkswagenfactory;

public class Factory {

    private static long countOfСreatedCars = 1_000_000;

    public static Car createCar(DetailModel model) {
        Car car = null;
        try {
            long vinNumber = (long)(Math.random() * countOfСreatedCars++);
            car = new Car(getCarBody(model), getEngine(model), getChassis(model), vinNumber, model);
            return car;

        } catch (DetailException e) {
            System.err.println("Ошибка при сборке машины! " + e.getMessage());
        }

        return car;
    }

    private static CarBody getCarBody(DetailModel model) throws DetailException {
        CarBody body = null;
        for (int i = 0; i < Storage.carBodyList.size();) {
            CarBody storageCarBody = Storage.carBodyList.get(i);
            if (storageCarBody.model == model) {
                body = storageCarBody;
                Storage.carBodyList.remove(i);
                break;
            } else {
                i ++;
            }
        }
        if (body == null) {
            throw new DetailException(String.format("Деталь кузов для модели %s отсутствует на складе!", model.name()));
        }
        return body;
    }

    private static Engine getEngine(DetailModel model) throws DetailException {
        Engine engine = null;
        for (int i = 0; i < Storage.engineList.size();) {
            Engine storageEngine = Storage.engineList.get(i);
            if (storageEngine.model == model) {
                engine = storageEngine;
                Storage.carBodyList.remove(i);
                break;
            } else {
                i ++;
            }
        }
        if (engine == null) {
            throw new DetailException(String
                    .format("Деталь двигатель для модели %s отсутствует на складе!", model.name()));
        }
        return engine;
    }

    private static Chassis getChassis(DetailModel model) throws DetailException {
        Chassis chassis = null;
        for (int i = 0; i < Storage.chassisList.size();) {
            Chassis storageChassies = Storage.chassisList.get(i);
            if (storageChassies.model == model) {
                chassis = storageChassies;
                Storage.carBodyList.remove(i);
                break;
            } else {
                i ++;
            }
        }
        if (chassis == null) {
            throw new DetailException(String
                    .format("Деталь шасси для модели %s отсутствует на складе!", model.name()));
        }
        return chassis;
    }




}
