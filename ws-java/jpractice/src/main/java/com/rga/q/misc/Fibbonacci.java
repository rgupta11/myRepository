package com.rga.q.misc;

import java.util.Arrays;

public class Fibbonacci {

    public static void main(String[] args){
        
        int[] arr = new int[10];
        Arrays.fill(arr, -1);
        System.out.println(arr);
        int n = 6;
        System.out.println("fib:" + n + "--" + fib(n));
    }
    
    //recursion - O(n^2)
    
    //For loop - using array lookup O(n)
    public static int fib(int n){
        
        if(n<=1)
            return 1;
        int[] arr = new int[n+1];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 1;
        System.out.println(0+ "-" + arr[0]);
        System.out.println(1+ "-" + arr[1]);
        for(int i = 2; i<=n; i++){
            arr[i] = arr[i-2] + arr[i-1];
            System.out.println(i+ "-" + arr[i]);
        }
        return arr[n];    
        
    }
    
}
