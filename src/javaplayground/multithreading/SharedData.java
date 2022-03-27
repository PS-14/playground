package javaplayground.multithreading;
  /*   
   Bluemoon
   09/08/21 11:02 AM  
   */

public  class SharedData {
    public volatile int turn;
    public int totalThreads;

    public SharedData(int turn, int totalThreads) {
        this.turn = turn;
        this.totalThreads = totalThreads;
    }

    public void setNextTurn() {
        this.turn = (this.turn + 1) % totalThreads;
    }
}
