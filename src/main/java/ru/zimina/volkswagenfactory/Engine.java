package ru.zimina.volkswagenfactory;

import static ru.zimina.volkswagenfactory.Main.logger;

public class Engine extends Detail {

    static final String detailName = "двигатель";

    public Engine(DetailModel model) {

        this.model = model;
        logger.trace("Создан объект класса Engine");
    }

    @Override
    public String toString() {
        return detailName + " (" + this.model.name() + ")";
    }

}
