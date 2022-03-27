package javaplayground.multithreading.printNumber;  
  /*   
   Bluemoon
   21/03/22 12:02 AM  
   */

import javaplayground.multithreading.SharedData;

public class PrintNumber extends Thread {
    private volatile SharedObject object;
    private int turn;

    public PrintNumber(String name, SharedObject object, int turn) {
        super(name);
        this.object = object;
        this.turn = turn;
    }

    public void run() {
        for (int i = 0; i < object.iteration; i++) {
            synchronized (object) {
                while (object.turn != turn) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + object.num);
                object.num++;
                object.turn=(object.turn+1)%2;
                object.notifyAll();
            }
        }
    }

}
