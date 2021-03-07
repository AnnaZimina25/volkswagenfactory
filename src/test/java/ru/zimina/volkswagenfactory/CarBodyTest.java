package ru.zimina.volkswagenfactory;

import org.junit.jupiter.api.*;

public class CarBodyTest {

    static CarBody poloCarBody;
    static CarBody jettaCarBody;

    @BeforeEach
    void createCarBodyObj () {
        poloCarBody = new CarBody(DetailModel.POLO);
        jettaCarBody = new CarBody(DetailModel.JETTA);
    }

    @DisplayName("CBT#1 проверка работы конструктора класса CarBody")
    @Test
    void testCarBodyConstructor() {

        Assertions.assertNotNull(poloCarBody);
        Assertions.assertNotNull(jettaCarBody);
        Assertions.assertNotNull(Engine.detailName);
    }

    @AfterEach
    void makeCarBodyObjNull() {
        poloCarBody = null;
        jettaCarBody = null;
    }
}
