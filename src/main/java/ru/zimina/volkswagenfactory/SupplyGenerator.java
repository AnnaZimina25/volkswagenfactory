package ru.zimina.volkswagenfactory;

import java.util.LinkedList;
import java.util.List;

import static ru.zimina.volkswagenfactory.Main.logger;

public class SupplyGenerator {

    static final int maxSupplyingDetailsCount = 150; // максимально возможное количество деталей в поставке

    public static List<Detail> generateSupply() {

       // Формируем список деталей в поставке
        List<Detail> detailsList = new LinkedList<>();
        int detailsCount = (int) (Math.random() * maxSupplyingDetailsCount);

        for (int i = 0; i < detailsCount; i++) {
            detailsList.add(generateDetail());
        }

        if (!detailsList.isEmpty()) {
            logger.info("Метод SupplyGenerator.generateSupply() сформировал поставку");
        } else {
            logger.debug("Метод SupplyGenerator.generateSupply() сформировал пустую поставку");
        }
        
        return detailsList;
        
    }
   
     static Detail generateDetail() {
        
       // Создаем детали с произвольным типом модели (либо JETTA либо POLO):
        CarBody randomBody = new CarBody(generateDetailModel());
        Engine randomEngine = new Engine(generateDetailModel());
        Chassis randomChassis = new Chassis(generateDetailModel());
        
        // Формируем массив из созданных деталей:
        Detail[] details = {randomBody, randomEngine,randomChassis};

        // Возвращаем произвольное значение из сформированного массива:
        return (Detail) getRandomElement(details);
    }
    
    static DetailModel generateDetailModel() {
        // Вовращает случайное значение из массива деталей
        return (DetailModel) getRandomElement(DetailModel.values());
    }
    
    private static Object getRandomElement(Object[] objectsArray) {
        int maxValue = objectsArray.length;
        int index = (int)(Math.random() * maxValue);

        // Вовращает случайное значение из массива объектов
        return objectsArray[index];
    }
}
