package com.rga.q.misc;

/**
 * The rule to calculate x % y is:
    if x < y, return x
    else subtract y from x until x < y
 */
public class Modulo {
    public static int mod(int x, int y){
        while (x>=y && y!=0){
            x -= y;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(mod(10, 3));  // Output: 1
        System.out.println(mod(20, 5));  // Output: 0
    }

}
