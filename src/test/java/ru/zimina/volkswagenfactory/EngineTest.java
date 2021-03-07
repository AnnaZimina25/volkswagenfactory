package ru.zimina.volkswagenfactory;

import org.junit.jupiter.api.*;

public class EngineTest {

    static Engine poloEngine;
    static Engine jettaEngine;

    @BeforeEach
    void createEngineObj () {
        poloEngine = new Engine(DetailModel.POLO);
        jettaEngine = new Engine(DetailModel.JETTA);
    }

    @DisplayName("ET#1 проверка работы конструктора класса Engine")
    @Test
    void testEngineConstructor() {

        Assertions.assertNotNull(poloEngine);
        Assertions.assertNotNull(jettaEngine);
        Assertions.assertNotNull(Engine.detailName);
    }

    @AfterEach
    void makeEngineObjNull() {
        poloEngine = null;
        jettaEngine = null;
    }
}
