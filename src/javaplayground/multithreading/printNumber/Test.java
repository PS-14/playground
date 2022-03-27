package javaplayground.multithreading.printNumber;  
  /*   
   Bluemoon
   21/03/22 12:02 AM  
   */

public class Test {
    public static void main(String[] args) {
        SharedObject sharedObject = new SharedObject(0, 0, 50);
        Thread t1 = new PrintNumber("t1", sharedObject, 0);
        Thread t2 = new PrintNumber("t2", sharedObject, 1);
        t1.start();
        t2.start();
    }


}
