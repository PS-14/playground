package oopsDesign.vendingmachine;  
  /*   
   Bluemoon
   24/03/22 8:17 PM  
   */

public class BruCoffeeService extends BeverageService {
    public void addMilk() {
        System.out.println("add hot milk");
    }

    public void addSugar() {
        System.out.println("add sugar");
    }

    public void addDrinkPowder() {
        System.out.println("add bru ");
    }

    public boolean doesPrepare(Beverages beverages) {
        return beverages == Beverages.BRU_COFFEE;
    }
}
