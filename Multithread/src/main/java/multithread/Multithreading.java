package multithread;

import sun.awt.windows.ThemeReader;

/**
 * Created by mariusz.przybysz on 2017-04-03.
 */
public class Multithreading {
    public static void main(String[] args) {
        /* z lambdami
        Thread thread = new Thread(()-> System.out.println(Thread.currentThread().getName()));
        thread.start();
        System.out.println(Thread.currentThread().getName());*/

        // metoda z przekazaniem kalsy runable
        new Thread(new MyRunnable()).start();
        new Thread(new MyRunnable()).start();
        new Thread(new MyRunnable()).start();
        new Thread(new MyRunnable()).start();
        new Thread(new MyRunnable()).start();
        //System.out.println(Thread.currentThread().getName());

        // metoda z lambdami
       /* new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
        Thread thread3 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        thread3.setName("Dupa");
        thread3.start();*/


    }

    static class MyRunnable implements Runnable {
        int counter =0;
        @Override
        public void run() {
            while (true) {
                System.out.println("Hello from thread " + Thread.currentThread().getName()+ "count: "+counter++);
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }


}