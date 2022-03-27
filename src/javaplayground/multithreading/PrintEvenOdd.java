package javaplayground.multithreading;
  /*   
   Bluemoon
   09/08/21 10:18 AM  
   */


public class PrintEvenOdd {


    public static void main(String[] args) {
        SharedData sharedData = new SharedData(0, 2);
        MyThread thread1 = new MyThread(2, 1, sharedData);
        MyThread thread2 = new MyThread(1, 0, sharedData);
        for (int i = 0; i < 50; i++) {
            thread1.start();
            thread2.start();
        }

    }
}
