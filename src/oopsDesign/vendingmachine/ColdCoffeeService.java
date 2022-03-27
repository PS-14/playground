package oopsDesign.vendingmachine;  
  /*   
   Bluemoon
   24/03/22 8:20 PM  
   */

public class ColdCoffeeService extends BeverageService {
    public void addMilk() {
        System.out.println("add cold milk");
    }

    public void addSugar() {
        System.out.println("add sugar");
    }

    public void addDrinkPowder() {
        System.out.println("add coffee concentrate");
    }
    public  boolean doesPrepare(Beverages beverages){
        return beverages==Beverages.COLD_COFFE;
    }
}
