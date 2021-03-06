package ru.zimina.volkswagenfactory;

import static ru.zimina.volkswagenfactory.Main.logger;

public class DetailException extends Exception {

    private String message;
    public DetailException(String message) {
        super(message);
        this.message = message;

        logger.trace("Создано нове исключение DetailException. " + message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
