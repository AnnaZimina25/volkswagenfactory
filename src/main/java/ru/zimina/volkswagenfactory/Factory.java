package ru.zimina.volkswagenfactory;

import java.util.List;

import static ru.zimina.volkswagenfactory.Main.logger;
import static ru.zimina.volkswagenfactory.Storage.*;

public class Factory {

    private static long countOfCreatedCars = 1_000_000;

    public static Car createCar(DetailModel model) throws DetailException, NullPointerException {

        Car car = null;

        CarBody body = getCarBody(model);
        Engine engine = getEngine(model);
        Chassis chassis = getChassis(model);

        if (body == null || engine == null || chassis == null) {
            logger.warn("Из метода Factory.createCar() проброшено исключение NullPointerException ");
            throw new NullPointerException("Ошибка при сборке автомобиля модели " + model + " model.name()\r\n" +
                    "Деталь не может быть null!");

        } else {
            long vinNumber = (long)(Math.random() * countOfCreatedCars++);

            if (model == DetailModel.JETTA) {
                car = new Jetta(body, engine, chassis, vinNumber);
            } else {
                car = new Polo(body, engine, chassis, vinNumber);
            }

            // Удаляем деиали из соответствующих списков деталей на складе, так как мы их использовали для сборки
            carBodyList.remove(body);
            engineList.remove(engine);
            chassisList.remove(chassis);

            logger.debug("Метод Factory.createCar() отработал корректно");
        }

        return car;
    }

    private static CarBody getCarBody(DetailModel model) throws DetailException {

        // Получаем деталь кузов заданного типа модели из списка кузовов на складе
        CarBody bodyResult = null;
        Detail body = getDetail(model, carBodyList, "кузов");

        if (body instanceof CarBody) {
            bodyResult = (CarBody) body;
            logger.debug("Метод Factory.getCarBody() отработал корректно");
        } else {
            logger.debug("Метод Factory.getCarBody() вернул null");

        }

        return bodyResult;
    }

    private static Engine getEngine(DetailModel model) throws DetailException {

        // Получаем деталь двигатель заданного типа модели из списка двигателей на складе
        Engine resultEngine = null;
        Detail engine  = getDetail(model, Storage.engineList, "двигатель");

        if (engine instanceof Engine) {
            resultEngine = (Engine) engine;
            logger.debug("Метод Factory.getEngine() отработал корректно");
        } else {
            logger.debug("Метод Factory.getEngine() вернул null");
        }

        return resultEngine;
    }

    private static Chassis getChassis(DetailModel model) throws DetailException {

        // Получаем деталь шасси заданного типа модели из списка шасси на складе
        Chassis resultChassis = null;
        Detail chassis  = getDetail(model, Storage.chassisList, "двигатель");

        if (chassis instanceof Chassis) {
            resultChassis = (Chassis) chassis;
            logger.debug("Метод Factory.getChassis() отработал корректно");
        } else {
        logger.debug("Метод Factory.getChassis() вернул null");
        }

        return resultChassis;
    }

    private static Detail getDetail(DetailModel model, List<Detail> detailsFromStorage, String detailName) throws DetailException {

        // Получаем объект Detail с заданным типом модели из заданного списка деталей:
        Detail detail = null;
        if (!detailsFromStorage.isEmpty()) {
            for (int i = 0; i < detailsFromStorage.size(); i++ ) {
                Detail detailFromStorage = detailsFromStorage.get(i);
                if (detailFromStorage.model == model) {
                    detail = detailFromStorage;
                    break;
                }
            }
        } else if (detailsFromStorage.isEmpty() || detail == null) {
            logger.warn("Из метода Factory.getDetail() проброшено исключение DetailException");
            throw new DetailException(String.format("Деталь %s для модели %s отсутствует на складе!", detailName, model.name()));
        }
        return detail;
    }

}
