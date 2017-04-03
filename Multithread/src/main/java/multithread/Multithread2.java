package multithread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mariusz.przybysz on 2017-04-03.
 */
public class Multithread2 {
    //atomic
    static AtomicInteger counter = new AtomicInteger(0);
// to samo tylko w klasie napisane
    static class Counter2{
      static   int counter2 = 0;

        static synchronized void increment(){
            ++counter2;
        }
}



    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new MyRunnable2());
        thread1.start();
        Thread thread2 = new Thread(new MyRunnable2());
        thread2.start();
        Thread thread3 = new Thread(new MyRunnable2());
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();


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
