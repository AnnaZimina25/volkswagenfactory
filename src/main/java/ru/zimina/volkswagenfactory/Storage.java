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

        List<Detail> suppliedDetails = generateSupply();

        for (Detail detail : suppliedDetails) {
            if (detail instanceof CarBody) {
                carBodyList.add(detail);
                logger.trace("В список список кузовов на складе добавлен новый объект из поставки");

            } else if (detail instanceof Engine ) {
                engineList.add(detail);
                logger.trace("В список список двигателей на складе добавлен новый объект из поставки");

            } else if (detail instanceof Chassis) {
                chassisList.add(detail);
                logger.trace("В список шасси на складе добавлен новый объект из поставки");
            } else {
                logger.warn("Метод Storage.acceptSupply() выбросил исключение DetailException(Деталь не опознана)");
                throw new DetailException ("Деталь не опознана!");
            }
        }



    }
}
