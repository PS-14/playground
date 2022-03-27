package oopsDesign.vendingmachine;  
  /*   
   Bluemoon
   24/03/22 8:22 PM  
   */

public class BadamMilkService extends BeverageService {
    public void addMilk() {
        System.out.println("add hot milk");
    }

    public void addSugar() {
        System.out.println("add sugar");
    }

    public void addDrinkPowder() {
        System.out.println("add badam mix powder");
    }

    public boolean doesPrepare(Beverages beverages) {
        return beverages == Beverages.BADAM_MILK;
    }
}
