package ru.zimina.volkswagenfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static ru.zimina.volkswagenfactory.Factory.createCar;

public class Main {

    public static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        // Генерируем поставку деталей на склад
        try {
            Storage.acceptSupply();
            logger.info("Поставка деталей поступила на склад");
        } catch (DetailException e) {
            logger.error("При сортировке поставки поймано исключение. " + e.getMessage());
        }

        // Создаем 2 вида машин и выводим их модели на экран
        try {
           Car poloCar = createCar(DetailModel.POLO);
           System.out.println(poloCar.toString());
           poloCar.printModel();

        } catch (DetailException | NullPointerException e) {
            logger.error("При создании объекта Polo поймано исключение " + e.getMessage());
        }

        try {
            Car jettaCar = Factory.createCar(DetailModel.JETTA);
            System.out.println(jettaCar.toString());
            jettaCar.printModel();

        } catch (DetailException | NullPointerException e) {
            logger.error("При создании объекта Jetta поймано исключение " + e.getMessage());
        }


    }
}
