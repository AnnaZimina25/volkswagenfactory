package ru.zimina.volkswagenfactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ru.zimina.volkswagenfactory.SupplyGenerator.*;

public class SupplyGeneratorTest {

    @DisplayName("SGT#1 проверка, что SupplyGenerator.generateDetailModel() " +
            "возвращает одно из значений перечисления DetailModel")
    @Test
    void testGenerateDetailModel () {
        DetailModel dm = generateDetailModel();
        Assertions.assertTrue(dm == DetailModel.JETTA || dm == DetailModel.POLO);

    }

    @DisplayName("SGT#2 проверка, что SupplyGenerator.generateDetail() " +
            "возвращает не null объект типа Detail одного из классов-наследников")
    @Test
    void testGenerateDetail () {

        Detail detail = generateDetail();
        Assertions.assertTrue(
                detail !=null ||
                        detail instanceof CarBody ||
                        detail instanceof Engine ||
                        detail instanceof Chassis
        );

    }

}
