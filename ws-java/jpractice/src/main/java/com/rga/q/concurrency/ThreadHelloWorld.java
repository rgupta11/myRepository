package com.rga.q.concurrency;

import java.util.Arrays;

public class ThreadHelloWorld {
    
    
    public static void main( String args[] ) throws InterruptedException {
        SumUpExample.runTest();
    }
}

class SumUpExample {

    long startRange;
    long endRange;
    long counter = 0;
    static long MAX_NUM = Integer.MAX_VALUE;

    public SumUpExample(long startRange, long endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public void add() {

        for (long i = startRange; i <= endRange; i++) {
            counter += i;
        }
    }

    static public void twoThreads() throws InterruptedException {

        long start = System.currentTimeMillis();
        SumUpExample s1 = new SumUpExample(1, MAX_NUM / 2);
        SumUpExample s2 = new SumUpExample(1 + (MAX_NUM / 2), MAX_NUM);

        Thread t1 = new Thread(() -> {
            s1.add();
        });

        Thread t2 = new Thread(() -> {
            s2.add();
        });

        t1.start();
        t2.start();
        
        t1.join();
        t2.join();

        long finalCount = s1.counter + s2.counter;
        long end = System.currentTimeMillis();
        System.out.println("Two threads final count = " + finalCount + " took  " + (end - start));
    }
    
    static void threeThreads() throws InterruptedException {
        
        long start = System.currentTimeMillis();
        long range = MAX_NUM / 3;
        SumUpExample s1 = new SumUpExample(1, range);
        SumUpExample s2 = new SumUpExample(1+range, 2*range);
        SumUpExample s3 = new SumUpExample(1+ (2*range), MAX_NUM);
        
        
        Thread t1 = new Thread(()->{
            s1.add();
        });
        
        Thread t2 = new Thread(()->{
            s2.add();
        });
        
        Thread t3 = new Thread(()-> {
            s3.add();
        });
        
        t1.start();
        t2.start();
        t3.start();
        
        t1.join();
        t2.join();
        t3.join();
        
        long finalCount = s1.counter + s2.counter + s3.counter;
        long end = System.currentTimeMillis();
        System.out.println("Three threads count = " + finalCount + " took" + (end-start));
        
    }
    
    static public void fourThreads() throws InterruptedException {

        long start = System.currentTimeMillis();
        long range = MAX_NUM / 4;
    
        SumUpExample s1 = new SumUpExample(1, range);
        SumUpExample s2 = new SumUpExample(1 + range, 2*range);
        SumUpExample s3 = new SumUpExample(1 + 2*range, 3*range);
        SumUpExample s4 = new SumUpExample(1 + 3*range, MAX_NUM);

        Thread t1 = new Thread(() -> {
            s1.add();
        });

        Thread t2 = new Thread(() -> {
            s2.add();
        });
        
        Thread t3 = new Thread(() -> {
            s3.add();
        });
        
        Thread t4 = new Thread(() -> {
            s4.add();
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        long finalCount = s1.counter + s2.counter + s3.counter + s4.counter;
        long end = System.currentTimeMillis();
        System.out.println("Four threads final count = " + finalCount + " took " + (end - start));
    }

    static public void oneThread() {

        long start = System.currentTimeMillis();
        SumUpExample s = new SumUpExample(1, MAX_NUM );
        s.add();
        long end = System.currentTimeMillis();
        System.out.println("Single thread final count = " + s.counter + " took " + (end - start));
    }
    
    

    public static void runTest() throws InterruptedException {

        oneThread();
        twoThreads();
        threeThreads();
        fourThreads();


        Thread testT = new Thread (new Runnable(){

            @Override
            public void run() {
                System.out.println("Hello from test thread");
            }
        });
        //What is differnce b/w new Runnalble() and ()-> ?
        // The difference is in the syntax and the way the Runnable is implemented.
        // The new Runnable() syntax is an anonymous inner class implementation,
        // while ()-> is a lambda expression that provides a more concise way to implement
        // the Runnable interface.  Both achieve the same result of creating a Runnable
        // instance, but the lambda expression is often preferred for its brevity and clarity,
        // Example code for both is shown below:

            /*Thread testT2 = new Thread(() -> {
                System.out.println("Hello from test thread");
            });*/
            
            /* runnable example 
            Thread testT2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hello from test thread");
                }
            });*/

        testT.start();
        testT.join();   // Join main thread with testT thread. It 
                        // waits for testT to finish before main thread can finish
                        // If join is not called, main thread may finish before testT prints its message
                        // and we may not see the message at all.
                        // If multiple threads are started, main thread will wait for all of them to finish
                        // before exiting.  Yes, it is a good practice
                        // to call join in the order of thread starts to maintain a 
                        // predictable execution flow.

        String str = "abcfghiseqlafps";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
    }
}






