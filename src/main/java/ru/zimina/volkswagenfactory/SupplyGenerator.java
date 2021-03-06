package ru.zimina.volkswagenfactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static ru.zimina.volkswagenfactory.Main.logger;

public class SupplyGenerator {

    static final int maxSupplyingDetailsCount = 150;

    public static List<Detail> generateSupply() {

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
   
    private static Detail generateDetail() {
        
        CarBody randomBody = new CarBody(generateDetailModel());
        Engine randomEngine = new Engine(generateDetailModel());
        Chassis randomChassis = new Chassis(generateDetailModel());
        
        Detail[] details = {randomBody, randomEngine,randomChassis};
        return (Detail) generateRandomValue(details);
    }
    
    private static DetailModel generateDetailModel() {
        
        return (DetailModel) generateRandomValue(DetailModel.values());
    }
    
    private static Object generateRandomValue(Object[] objectsArray) {
        int maxValue = objectsArray.length;
        int index = (int)(Math.random() * maxValue);
        
        return objectsArray[index];
    }
}
