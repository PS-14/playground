package oopsDesign.vendingmachine;  
  /*   
   Bluemoon
   24/03/22 8:14 PM  
   */

public abstract class BeverageService {
    public final void prepareDrink() {
        addMilk();
        addSugar();
        addDrinkPowder();
        System.out.println("########### drink prepared #############");
    }

    public abstract void addMilk();

    public abstract void addSugar();

    public abstract void addDrinkPowder();

    public abstract boolean doesPrepare(Beverages beverages);

}
