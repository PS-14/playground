package java.multithreading;  
  /*   
   Bluemoon
   09/08/21 10:18 AM  
   */

public class MyThread extends Thread {

    private int start;

    private int seqNumber;
    private SharedData sharedData;

    public MyThread(int start, int turn, SharedData sharedData) {
        this.start = start;
        this.seqNumber = turn;
        this.sharedData = sharedData;
    }


    @Override
    public void run() {
        printNumber();
    }

    private synchronized void printNumber() {
        while (sharedData.turn != seqNumber) {
            try {
                sharedData.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Even :" + start);
        start = start + 2;
        sharedData.setNextTurn();
        notifyAll();
    }
}
