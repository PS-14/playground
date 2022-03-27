package oopsDesign.vendingmachine;  
  /*   
   Bluemoon
   24/03/22 8:19 PM  
   */

public class BournvitaService extends BeverageService {
    public void addMilk() {
        System.out.println("add low heat milk");
    }

    public void addSugar() {
        System.out.println("add sugar");
    }

    public void addDrinkPowder() {
        System.out.println("add bournvita ");
    }
    public  boolean doesPrepare(Beverages beverages){
        return beverages==Beverages.BOURNVITA;
    }
}
