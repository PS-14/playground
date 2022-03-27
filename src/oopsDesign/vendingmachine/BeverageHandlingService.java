package oopsDesign.vendingmachine;  
  /*   
   Bluemoon
   24/03/22 8:23 PM  
   */

import java.util.List;

public class BeverageHandlingService {
    List<BeverageService> beveragesList;

    public BeverageHandlingService(List<BeverageService> beverageServices) {
        this.beveragesList = beverageServices;
    }

    public void prepareDrink(Beverages beverages) {
        BeverageService beverageService = beveragesList.stream().filter(bs -> {
            return bs.doesPrepare(beverages);
        }).findFirst().orElse(null);
        if (beverageService == null) {
            System.out.println("#######Drink not available#######");
            return;
        }
        beverageService.prepareDrink();
    }
}
