package com.rga.q.crackingCodingQ.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * Problem: Parallel File Processing Simulation

    You are given a list of file sizes (integers).
 *  Goal:

    Compute the total processing time using parallelism with these rules:

    Each file takes size * 10 ms to process.
    Use a fixed thread pool to process files in parallel.
    Additionally:
    Use a ForkJoin task to compute the sum of file sizes (divide & conquer).
    Combine results:
    Total processing time (from thread pool)
    Total size (from fork/join)

    time complexity: O(n) for processing files and O(n) for summing file sizes, resulting in O(n) overall.
    space complexity: O(n) for storing file sizes and results.
 */
public class FileParallel {
   

    public static void main(String[] args) {
        List<Integer> files = Arrays.asList(10, 20, 309, 40);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futures = new ArrayList<>();

        // Submit all file processing tasks
        for (Integer fileSize : files) {
            futures.add(executor.submit(() -> {
                try {
                    int time = fileSize * 10;
                    Thread.sleep(fileSize * 10); // Simulate processing time
                    System.out.println("Processed file: " + fileSize +
                            " by " + Thread.currentThread().getName());
                    return time;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return 0;
                }
            }));
        }

        // Aggregate total processing time
        int totalTime = 0;
        for (Future<Integer> future : futures) {
            try {
                totalTime += future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        System.out.println("Total Processing Time: " + totalTime);

    }
}
