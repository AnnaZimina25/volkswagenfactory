package ru.zimina.volkswagenfactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static ru.zimina.volkswagenfactory.SupplyGenerator.generateSupply;

public class Storage {

    static List<CarBody> carBodyList = new LinkedList<>();
    static List<Engine> engineList = new LinkedList<>();
    static List<Chassis> chassisList = new LinkedList<>();

    public static void acceptSupply() throws DetailException {

        List<Detail> suppliedDetails = generateSupply();

        for (Detail detail : suppliedDetails) {
            if (detail instanceof CarBody) {
                carBodyList.add((CarBody) detail);

            } else if (detail instanceof Engine ) {
                engineList.add((Engine) detail);
            } else if (detail instanceof Chassis) {
                chassisList.add((Chassis) detail);
            } else {
                throw new DetailException ("Деталь не опознана!");
            }
        }



    }
}
