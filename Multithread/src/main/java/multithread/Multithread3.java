package multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mariusz.przybysz on 2017-04-03.
 */
public class Multithread3 {
    //atomic
    static AtomicInteger counter = new AtomicInteger(0);
    // to samo tylko w klasie napisane
    static class Counter2{
        static   int counter2 = 0;

        static synchronized void increment(){
            ++counter2;
        }
    }

   static ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {

        pool.execute(new MyRunnable2());
        pool.execute(new MyRunnable2());
        pool.execute(new MyRunnable2());
        pool.submit(new MyRunnable2());
        pool.submit(new MyRunnable2());
        pool.shutdown();
        try {
            pool.awaitTermination(100, TimeUnit.NANOSECONDS);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }


        System.out.println(counter);
        System.out.println(Counter2.counter2);
    }


    static class MyRunnable2 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1_000_000; ++i) {
                /*synchronized (Multithread2.class){
                ++counter;}*/
                counter.incrementAndGet();
                Counter2.increment();
            }
            System.out.println("finished : "+ Thread.currentThread().getName());
        }


    }



}
