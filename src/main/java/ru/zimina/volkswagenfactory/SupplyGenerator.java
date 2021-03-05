package ru.zimina.volkswagenfactory;

import java.util.ArrayList;
import java.util.List;

public class SupplyGenerator {

    static final int maxSupplyingDetailsCount = 150;

    public static List<Detail> generateSupply() {

        List<Detail> detailsList = new ArrayList<>();
        int detailsCount = (int) (Math.random() * maxSupplyingDetailsCount);

        for (int i = 0; i < maxSupplyingDetailsCount; i++) {
            detailsList.add(generateDetail());
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
