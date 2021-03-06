package ru.zimina.volkswagenfactory;

import static ru.zimina.volkswagenfactory.Main.logger;

public class CarBody extends Detail {

    static final String detailName = "кузов";


    public CarBody(DetailModel model) {
        this.model = model;
        logger.trace("Создан новый объект CarBody");
    }

    @Override
    public String toString() {
        return detailName + " (" + this.model.name() + ")";
    }
}
