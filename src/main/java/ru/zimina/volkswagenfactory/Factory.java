package ru.zimina.volkswagenfactory;

import java.util.List;

import static ru.zimina.volkswagenfactory.Main.logger;

public class Factory {

    private static long countOfCreatedCars = 1_000_000;

    public static Car createJetta() throws DetailException, NullPointerException {
        DetailModel model = DetailModel.JETTA;
        long vinNumber = (long)(Math.random() * countOfCreatedCars++);
        Jetta jetta = new Jetta(getCarBody(model), getEngine(model), getChassis(model), vinNumber);

        if (jetta == null) {
            logger.warn("Из метода Factory.createJetta() проброшено исключение NullPointerException ");
            throw new NullPointerException("Ошибка при сборке автомобиля модели" + model.name());
        } else {
            logger.info("Метод Factory.createJetta() отработал корректно");
        }

        return jetta;
    }

    public static Polo createPolo() throws DetailException, NullPointerException {

        DetailModel model = DetailModel.POLO;
        long vinNumber = (long)(Math.random() * countOfCreatedCars++);
        Polo polo = new Polo(getCarBody(model), getEngine(model), getChassis(model), vinNumber);

        if (polo == null) {
            logger.warn("Из метода Factory.createPolo() проброшено исключение NullPointerException ");
            throw new NullPointerException("Ошибка при сборке автомобиля модели" + model.name());
        } else {
            logger.debug("Метод Factory.createPolo() отработал корректно");
        }

        return polo;
    }

    private static CarBody getCarBody(DetailModel model) throws DetailException {

        // Получаем деталь кузов заданного типа модели из списка кузовов на складе
        CarBody bodyResult = null;
        Detail body = getDetail(model, Storage.carBodyList, "кузов");

        if (body instanceof CarBody) {
            Storage.carBodyList.remove(body);
            bodyResult = (CarBody) body; // если найденная деталь удовлетворяет требованиям, забираем её со склада
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
            Storage.engineList.remove(engine);
            resultEngine = (Engine) engine; // если найденная деталь удовлетворяет требованиям, забираем её со склада
            logger.info("Метод Factory.getEngine() отработал корректно");
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
            Storage.chassisList.remove(chassis); // если найденная деталь удовлетворяет требованиям, забираем её со склада
            resultChassis = (Chassis) chassis;
            logger.info("Метод Factory.getChassis() отработал корректно");
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
            logger.warn("Из метода Factory.getDetail проброшено исключение DetailException");
            throw new DetailException(String.format("Деталь %s для модели %s отсутствует на складе!", detailName, model.name()));
        }
        return detail;
    }

}
