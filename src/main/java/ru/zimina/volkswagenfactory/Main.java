package ru.zimina.volkswagenfactory;

public class Main {

    public static void main(String[] args) {

        // Генерируем поставку деталей на склад
        try {
            Storage.acceptSupply();
        } catch (DetailException e) {
            System.err.println("Ошибка поставки на склад! " + e.getMessage());
        }

        // Создаем 2 вида машин и выводим их модели на экран
        Car poloCar = Factory.createCar(DetailModel.POLO);
        Car jettaCar = Factory.createCar(DetailModel.JETTA);

        System.out.println("Поло: " + poloCar.model);
        System.out.println("Джетта: " + jettaCar.model);


    }
}
