package javaplayground.multithreading.readwritelock;  
  /*   
   Bluemoon
   21/03/22 2:13 PM  
   */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    ReadWriteLock readWriteLock;
    int num;
    ExecutorService THREAD_POOL;

    public ReadWriteLockTest(int n) {
        this.num = n;
        readWriteLock = new ReentrantReadWriteLock(false);
        THREAD_POOL = Executors.newFixedThreadPool(10);
    }

    private void test() {
        for (int i = 0; i < 100; i++) {
            THREAD_POOL.submit(() -> {
                incrementNumber();
                //System.out.println(num);
            });
        }
        System.out.println("last num:" + num);
    }

    private void test1() {
        try {
            for (int i = 0; i < 100; i++) {
                THREAD_POOL.submit(() -> {
                    readWriteLock.writeLock().lock();
                    incrementNumber();
                    //System.out.println(num);

                });
            }
            System.out.println("last num:" + num);
        } catch (Exception e) {

        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    private void incrementNumber() {
        num++;
    }

    public static void main(String[] args) {
        ReadWriteLockTest test = new ReadWriteLockTest(1);
        test.test();
        test.num = 1;
        test.test1();
    }
}
