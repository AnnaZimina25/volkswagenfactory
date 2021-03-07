package ru.zimina.volkswagenfactory;

import org.junit.jupiter.api.*;

public class JettaTest {

    static Jetta jetta;

    @BeforeEach
    void createJettaObj () {
        DetailModel model = DetailModel.JETTA;
        jetta = new Jetta(new CarBody(model), new Engine(model), new Chassis(model), 422313);
    }

    @DisplayName("JT#1 проверка работы конструктора класса Jetta")
    @Test
    void testJettaConstructor() {
        Assertions.assertNotNull(jetta);
        Assertions.assertNotNull(jetta.body);
        Assertions.assertNotNull(jetta.engine);
        Assertions.assertNotNull(jetta.chassis);
        Assertions.assertNotNull(jetta.vinNumber);
        Assertions.assertNotNull(Jetta.model);
    }

    @AfterEach
    void makeJettaObjNull() {
        jetta = null;
    }
}
