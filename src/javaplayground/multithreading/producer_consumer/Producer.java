package javaplayground.multithreading.producer_consumer;  
  /*   
   Bluemoon
   20/03/22 11:38 PM  
   */

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {
    private Queue<Integer> queue;
    private int iteration;
    private int capacity;

    public Producer(Queue<Integer> queue, int iteration,int capacity) {
        this.queue = queue;
        this.iteration = iteration;
        this.capacity=capacity;

    }

    @Override
    public void run() {
        for (int i = 0; i < iteration; i++) {
            synchronized (queue) {
                while (queue.size() >= capacity) {
                    System.out.println(Thread.currentThread().getId()+" Producer: queue is not empty");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int number=new Random().nextInt(100);
                System.out.println(Thread.currentThread().getId()+" Producer : produced "+number );
                queue.add(number);
                queue.notify();
            }
        }
    }
}
