package ru.zimina.volkswagenfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        // Генерируем поставку деталей на склад
        try {
            Storage.acceptSupply();
            logger.info("Сформирована поставка на склад");
        } catch (DetailException e) {
            logger.error("При генерации поставки поймано исключение" + e.getMessage());
        }

        // Создаем 2 вида машин и выводим их модели на экран
        try {
           Car poloCar = Factory.createPolo();
           System.out.println(poloCar.toString());
           poloCar.printModel();

        } catch (DetailException e) {
            logger.error("При создании объекта Polo поймано исключение " + e.getMessage());
        } catch (NullPointerException e) {
            logger.error("При печати объекта Polo поймано исключение " + e.getMessage());
        }

        try {
            Car jettaCar = Factory.createJetta();
            System.out.println(jettaCar.toString());
            jettaCar.printModel();

        } catch (DetailException e) {
            logger.error("При создании объекта Jetta поймано исключение " + e.getMessage());
        } catch (NullPointerException e) {
            logger.error("При печати объекта Jetta поймано исключение " + e.getMessage());
        }


    }
}
