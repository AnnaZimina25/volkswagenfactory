package ru.zimina.volkswagenfactory;

import org.junit.jupiter.api.*;

public class PoloTest {

    static Polo polo;

    @BeforeEach
    void createPoloObj () {
        DetailModel model = DetailModel.POLO;
        polo = new Polo(new CarBody(model), new Engine(model), new Chassis(model), 422313);
    }

    @DisplayName("PT#1 проверка работы конструктора класса Polo")
    @Test
    void testPoloConstructor() {
        Assertions.assertNotNull(polo);
        Assertions.assertNotNull(polo.body);
        Assertions.assertNotNull(polo.engine);
        Assertions.assertNotNull(polo.chassis);
        Assertions.assertNotNull(polo.vinNumber);
        Assertions.assertNotNull(Polo.model);
    }

    @AfterEach
    void makePoloObjNull() {
        polo = null;
    }

}
