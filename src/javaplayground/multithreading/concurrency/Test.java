package javaplayground.multithreading.concurrency;
  /*   
   Bluemoon
   20/03/22 11:21 PM  
   */

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        submitTask();
    }
    public static void submitTask() {
        Future<String> output = ExecutorTest.THREAD_POOL.submit(() -> {
            Thread.sleep(300);
            return "completed";
        });
        try {
            System.out.println("Thread inside execution:" + Thread.currentThread().getName());
            boolean isCompleted = output.isDone();
            System.out.println("isComplted: " + isCompleted);
            String res = output.get(300, TimeUnit.MILLISECONDS);
            System.out.println("Result is :" + res);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }finally {

        }
    }
}
