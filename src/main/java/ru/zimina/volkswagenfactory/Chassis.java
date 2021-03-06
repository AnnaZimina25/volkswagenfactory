package ru.zimina.volkswagenfactory;

import static ru.zimina.volkswagenfactory.Main.logger;

public class Chassis extends Detail  {

    static final String detailName = "шасси";

    public Chassis(DetailModel model) {
        this.model = model;
        logger.trace("Создан новый объект Chassis");
    }

    @Override
    public String toString() {
        return detailName + " (" + this.model.name() + ")";
    }
}
