package javaplayground.multithreading.producer_consumer;  
  /*   
   Bluemoon
   20/03/22 11:42 PM  
   */

import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<Integer> queue;
    private int iteration;


    public Consumer(Queue<Integer> queue, int iteration) {
        this.queue = queue;
        this.iteration = iteration;

    }

    @Override
    public void run() {
        for (int i = 0; i < iteration; i++) {
            synchronized (queue) {
                while (queue.size() == 0) {
                    System.out.println(Thread.currentThread().getId()+" Consumer: queue is empty");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int number = queue.poll();
                System.out.println(Thread.currentThread().getId()+" Consumer : consumed " + number);
                queue.notify();
            }
        }
    }
}
