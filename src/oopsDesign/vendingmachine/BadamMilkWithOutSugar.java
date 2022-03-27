package oopsDesign.vendingmachine;  
  /*   
   Bluemoon
   24/03/22 8:36 PM  
   */

public class BadamMilkWithOutSugar extends BeverageService {
    public void addMilk() {
        System.out.println("add hot milk");
    }

    public void addSugar() {
    }

    public void addDrinkPowder() {
        System.out.println("add badam mix powder");
    }

    public boolean doesPrepare(Beverages beverages) {
        return beverages == Beverages.BADAM_MILK_WITHOUT_SUGAR;
    }
}
