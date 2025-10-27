package com.rga.q.misc;


/**
 * Sliding Window to find out max profit from stock prices
 * Array represents stock prices on different days say ith element 
 * represents price on ith day
 * Buy on one day and sell on another day
 * Make only one transaction
 * Find max profit by buying and selling once
 * 
 * Its a variation of Kadane's algorithm
 * Implemented using 2 pointers 
 * https://www.youtube.com/watch?v=1pkOgXD63yU&list=PLot-Xpze53ldVwtstag2TL4HQhAnC8ATf&index=2
 */
public class SlidingWindow {

    public static double maxProfit(double[] prices){

        //null/empty check
        if (prices == null || prices.length <= 1){
            return 0.0;
        }
        double maxProfit = 0.0;
        int leftBuyP = 0;
        int rightSellP = 1;

        while (rightSellP < prices.length) {
            //profitable
            if (prices[leftBuyP] < prices[rightSellP]) {
                double profit = prices[rightSellP] - prices[leftBuyP];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            } else {
                //not profitable, move left pointer to right pointer
                leftBuyP =  rightSellP;
            }
            //in all cases move right pointer
            rightSellP++;
        }
        return maxProfit;
    }

    public static void main (String[] args){

        double[] prices = {7.0,1.0,5.0,3.0,6.0,4.0};
        double result = maxProfit(prices);
        System.out.println("Max profit: " + result);

    }
    
}
