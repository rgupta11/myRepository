package com.rga.q.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.rowset.spi.SyncFactory;
import java.util.concurrent.*;
import 

public class ThreadMain {
    
    private int counter = 0;

    //Sync method
    // public synchronized void incr(){
    //     counter++; //2000
    // }


    //sync blocks
    // public void incr(){
    //     synchronized(this){
    //         counter++; //2000
    //     }
    // }

    //Unsync
    public void incr(){
        counter++; //1843
    }


    public int getCounter(){
        return counter;
    }

    public static void main(String[] args) {
        
        ThreadMain tm = new ThreadMain();
        Thread t1 = new Thread(() -> {
            for (int i=0; i<1000; i++) {
                tm.incr();    
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run(){
               for (int i=0; i<1000; i++) {
                   tm.incr();
               } 
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
        
        }
        System.out.println("Counter:" + tm.getCounter());
        
        
        //Cache coleascing or 
        String userId = ""; //cache userId
        ConcurrentHashMap<String, CompletableFuture> inflight = new ConcurrentHashMap<>();
        CompletableFuture<String> future = inflight.computeIfAbsent(userId, 
            key -> CompletableFuture.supplyAsync(() -> {
                   try {
                        //String value = loadFromDB();
                        //Cache.put (key, value);
                        return userId;
                   } catch (Exception e) {

                   }finally {

                   } 
            }));
    }
}
