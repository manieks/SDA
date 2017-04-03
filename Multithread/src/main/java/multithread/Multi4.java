package multithread;

import java.io.IOException;

/**
 * Created by mariusz.przybysz on 2017-04-03.
 */
public class Multi4 {
    public static void main(String[] args) throws IOException {


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("strarted: " + Thread.currentThread().getName());

                try {
                    synchronized (this){
                    this.wait();      }}

                catch (InterruptedException e) {   e.printStackTrace();   }

                System.out.println("finished: " + Thread.currentThread().getName());


            }
        };


        new Thread(runnable).start();
        System.in.read();

        synchronized (runnable){runnable.notify();}


    }


}
