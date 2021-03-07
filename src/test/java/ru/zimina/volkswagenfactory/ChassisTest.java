package ru.zimina.volkswagenfactory;

import org.junit.jupiter.api.*;

public class ChassisTest {

    static Chassis poloChassis;
    static Chassis jettaChassis;

    @BeforeEach
    void createChassisObj () {
        poloChassis = new Chassis(DetailModel.POLO);
        jettaChassis = new Chassis(DetailModel.JETTA);
    }

    @DisplayName("CT#1 проверка работы конструктора класса Chassis")
    @Test
    void testChassisConstructor() {

        Assertions.assertNotNull(poloChassis);
        Assertions.assertNotNull(jettaChassis);
        Assertions.assertNotNull(Engine.detailName);
    }

    @AfterEach
    void makeChassisObjNull() {
        poloChassis = null;
        jettaChassis = null;
    }
}
