package ru.zimina.volkswagenfactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static ru.zimina.volkswagenfactory.Main.logger;
import static ru.zimina.volkswagenfactory.SupplyGenerator.generateSupply;

public class Storage {

    static List<Detail> carBodyList = new LinkedList<>();
    static List<Detail> engineList = new LinkedList<>();
    static List<Detail> chassisList = new LinkedList<>();

    public static void acceptSupply() throws DetailException {

        List<Detail> suppliedDetails = new LinkedList<>();

        // Формируем поставку до тех пор, пока она не перестанет быть пустым списком:
        while (suppliedDetails.isEmpty()) {
            suppliedDetails = generateSupply();
        }

        // Проходимся по списку полученных деталей в поставке и сортируем их по спискам склада по типу детали:
        for (Detail detail : suppliedDetails) {
            if (detail instanceof CarBody) {
                carBodyList.add(detail);
                logger.info("В список кузовов на складе добавлен новый объект из поставки");

            } else if (detail instanceof Engine) {
                engineList.add(detail);
                logger.info("В список двигателей на складе добавлен новый объект из поставки");

            } else if (detail instanceof Chassis) {
                chassisList.add(detail);
                logger.info("В список шасси на складе добавлен новый объект из поставки");
            } else {
                logger.warn("Метод Storage.acceptSupply() выбросил исключение DetailException(Деталь не опознана)");
                throw new DetailException("Деталь не опознана!");
            }
        }
    }
}
