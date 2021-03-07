package ru.zimina.volkswagenfactory;

import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.junit.jupiter.api.*;

import java.util.List;

import static ru.zimina.volkswagenfactory.Storage.*;

public class StorageTest {

    @BeforeEach
    void doAcceptSupply() {
        try {
            acceptSupply();
        } catch (DetailException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("ST#1 проверка, что Storage.acceptSupply() " +
            "сортирует случайный спискок деталей по их типу")
    @Test
    void testCorrectDetailsSorting () {
        for (Detail detail : carBodyList) {
            Assertions.assertTrue(detail instanceof CarBody);
        }

        for (Detail detail : engineList) {
            Assertions.assertTrue(detail instanceof Engine);
        }

        for (Detail detail : chassisList) {
            Assertions.assertTrue(detail instanceof Chassis);
        }

    }
}
