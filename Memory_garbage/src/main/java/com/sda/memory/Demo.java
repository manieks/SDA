package com.sda.memory;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

        int size = 100;

        long startTime = System.currentTimeMillis();
        try {
            while (true) {
                int[] array = new int[size];
                size += size;
                Thread.sleep(1000);
            }

        }catch (OutOfMemoryError e){
            long stopTime = System.currentTimeMillis();
            long durationInSec = (stopTime - startTime) / 1000;
            System.out.println("Program działał przez:"+durationInSec+" sek.");

        }

    }
}
