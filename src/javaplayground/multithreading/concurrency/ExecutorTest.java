package javaplayground.multithreading.concurrency;
  /*   
   Bluemoon
   20/03/22 9:41 PM  
   */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {



    public static  final ExecutorService THREAD_POOL = new ThreadPoolExecutor(5, 10, 10, TimeUnit.MINUTES, new LinkedBlockingQueue<>(5000));


}
