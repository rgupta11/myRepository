package com.rga.q.misc.features;

import java.util.Arrays;

/**
 * 
 *  A cafeteria table consists of a row of N seats, numbered from 1 to N 
    from left to right. Social distancing guidelines require that every diner be 
    seated such that K seats to their left and K seats to their right 
    (or all the remaining seats to that side if there are fewer than K) remain empty. 
    There are currently M diners seated at the table, the ith of whom is in seat S(i).
 * 
 * Sample test case #1
 * N = 10
 * K = 1
 * M = 2
 * S = [2, 6]
 *
 * Algo 

 * -Sort the array S of occupied seat numbers.
 * -Check if the gap between consecutive diners is at least 2k+1
 * (minimum space for one diner and K empty seats on both sides)
 * -Also check the edges (beginning of seats before the first diner and
 * end of seats after the last diner) to ensure distancing is maintained
 * there.
 */
public class socialdistancing {
    
    //n=no of seats
    //k=seats to be left empty on both sides
    //s=occupied seats
    public int getMaxAdditionalDinersCount(int n, int k, int[] s) {
        int minSeats = k + 1;
        int m = s.length;
        //If no seat is occupied
        if (m == 0) {
            return n / minSeats + 1;
        }
        //Sort the occupied seats
        Arrays.sort(s);

        int result = 0;

        int firstChair = s[0];
        int firstAvailableIndex = (firstChair - 1) - minSeats;
        if (firstAvailableIndex >= 0) {
            result += firstAvailableIndex / minSeats + 1;
        }

        for (int index = 0; index < m - 1; index++) {

            int leftFreeChair = s[index] + minSeats;
            int rightFreeChair = s[index + 1] - minSeats;
            int diffSpace = rightFreeChair - leftFreeChair;
            if (diffSpace >= 0) {
                result += diffSpace / minSeats + 1;
        }

        int lastChair = s[m - 1];
        int lastAvailableIndex = (lastChair - 1) + minSeats;
        if (lastAvailableIndex <= n-1) {
            result += (n - 1 - lastAvailableIndex)/ minSeats + 1;
        }

        return result;
    }


}
