package ru.zimina.volkswagenfactory;

public class DetailException extends Exception {

    private String message;
    public DetailException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
