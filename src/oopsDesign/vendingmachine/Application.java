package oopsDesign.vendingmachine;  
  /*   
   Bluemoon
   24/03/22 8:14 PM  
   */

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<BeverageService> beverageServiceList = new ArrayList<>();
        beverageServiceList.add(new BruCoffeeService());
        beverageServiceList.add(new ColdCoffeeService());
        beverageServiceList.add(new BadamMilkService());
        beverageServiceList.add(new BournvitaService());
        beverageServiceList.add(new BadamMilkWithOutSugar());

        BeverageHandlingService beverageHandlingService = new BeverageHandlingService(beverageServiceList);
        beverageHandlingService.prepareDrink(Beverages.BADAM_MILK_WITHOUT_SUGAR);
    }
}
