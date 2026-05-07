package com.rga.q.crackingCodingQ.dp;

public class ClimbingStairs {
    /**
     * You are climbing a staircase. It takes n steps to reach the top. Each time you can 
     * either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * 
     * 
     */
    private ClimbingStairs() {
        // Private constructor to prevent instantiation
    }
    public static int stairsTabulation(int n){

        if(n <= 1)
            return 1;

        int prev = 1; // ways for 1 step
        int curr = 1; // ways for 0 steps, but we'll start from 2

        for (int i = 2; i <= n; i++){
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }    

    public static void main(String[] args) {
        System.out.println(stairsTabulation(10));
    }

}
