package javaplayground.multithreading.producer_consumer;  
  /*   
   Bluemoon
   20/03/22 11:37 PM  
   */

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList();
        int iteration = 10;
        Producer producer = new Producer(queue, iteration, 5);
        Consumer consumer = new Consumer(queue, iteration);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        Thread t3 = new Thread(producer);
        Thread t4 = new Thread(producer);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
