package ru.zimina.volkswagenfactory;

import org.junit.jupiter.api.*;

import static ru.zimina.volkswagenfactory.Factory.createCar;
import static ru.zimina.volkswagenfactory.Storage.*;

public class FactoryTest {

    static Car polo;
    static Car jetta;

    @BeforeEach
    void addElementsToDetailsStorageList() {
        carBodyList.add(new CarBody(DetailModel.POLO));
        carBodyList.add(new CarBody(DetailModel.JETTA));
        engineList.add(new Engine(DetailModel.POLO));
        engineList.add(new Engine(DetailModel.JETTA));
        chassisList.add(new Chassis(DetailModel.POLO));
        chassisList.add(new Chassis(DetailModel.JETTA));

        try {
            polo = createCar(DetailModel.POLO);
            jetta = createCar(DetailModel.JETTA);
        } catch (DetailException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("FT#1 проверяет, что метод Factory.createCar() " +
            "возвращает не null обьект c не null полями типа Polo или бросает исключение")
    @Test
    void testCreatePoloCar() {

        Assertions.assertNotNull(polo);
        Assertions.assertTrue(polo instanceof Polo);
        Assertions.assertNotNull(polo.body);
        Assertions.assertNotNull(polo.engine);
        Assertions.assertNotNull(polo.chassis);

    }

    @DisplayName("FT#2 проверяет, что метод Factory.createCar() " +
            "возвращает не null обьект c не null полями типа Jetta или бросает исключение")
    @Test
    void testCreateJettaCar() {

        Assertions.assertNotNull(jetta);
        Assertions.assertTrue(jetta instanceof Jetta);
        Assertions.assertNotNull(jetta.body);
        Assertions.assertNotNull(jetta.engine);
        Assertions.assertNotNull(jetta.chassis);


    }

    @DisplayName("FT#3 проверяет, что при успешном создании объекта типа Car в методе Factory.createCar()," +
            "использованные детали удаляются из списков на складе ")
    @Test
    void testRemovingDetailsAfterCreatingCar() {

        Assertions.assertTrue(carBodyList.isEmpty());
        Assertions.assertNotNull(engineList.isEmpty());
        Assertions.assertNotNull(chassisList.isEmpty());

    }



    @AfterEach
    void clearDetailsStorageList() {
        carBodyList.clear();
        engineList.clear();
        chassisList.clear();

        polo = null;
        jetta = null;

    }

}
