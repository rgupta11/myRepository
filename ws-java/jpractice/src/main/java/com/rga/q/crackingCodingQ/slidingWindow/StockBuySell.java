package com.rga.q.slidingWindow;

public class StockBuySell {
    
    static int maxProfit(int[] prices) {

        //int[] prices = {7,1,5,3,6,4};
        int left = 0; // Buy
        int right = 1; // Sell
        int maxProfit = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                left = right; // Move the left pointer to the right
            }
            right++; // Move the right pointer to the right
        }

        return maxProfit;

        /**
         * each pass
         * pass 1 - 
         * left = 0, right = 1, maxProfit = 0 - prices[left] = 7, prices[right] = 1, maxProfit = 0
         * prices[left] < prices[right] is false, left = right = 1, right = 2
         * 
         * pass 2 -
         * left = 1, right = 2, maxProfit = 0 - prices[left] = 1, prices[right] = 5, maxProfit = 4
         * prices[left] < prices[right] is true, profit = 4, maxProfit = 4, right = 3   
         * 
         * pass 3 -
         * left = 1, right = 3, maxProfit = 4 - prices[left] = 1, prices[right] = 3, maxProfit = 4
         * prices[left] < prices[right] is true, profit = 2, maxProfit = 4, right = 4
         * 
         * pass 4 - 
         * left = 1, right = 4, maxProfit = 4 - prices[left] = 1, prices[right] = 6, maxProfit = 5
         * prices[left] < prices[right] is true, profit = 5, maxProfit = 5, right = 5
         * 
         * pass 5 -
         * left = 1, right = 5, maxProfit = 5 - prices[left] = 1, prices[right] = 4, maxProfit = 5
         * prices[left] < prices[right] is true, profit = 3, maxProfit = 5, right = 6   
         * 
         * pass 6 - right pointer reaches the end of the array, return maxProfit = 5
         * 
         */
    }

    public static void main(String[] args) {

        /**
         * 
         * You are given an array of integers where the i-th element represents the price of a stock on day i. 
         * You want to maximize your profit by choosing a single day to buy one stock and choosing a different 
         * day in the future to sell that stock. 
         * 
         * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, 
         * return 0.
         * 
         * Example 1:
         * Input: prices = [7,1,5,3,6,4]
         * Output: 5
         * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
         * 
         * Approach:
         * Category - Sliding Window because we are looking for a contiguous subarray and we want to
         * find the maximum profit that can be achieved by buying and selling a stock on different days.
         * 
         * 1. Initialize two pointers, left and right, to the beginning of the array.
         * 
         * 2. Initialize a variable to keep track of the maximum profit found so far.
         * 
         * 3. Move the right pointer to the right, calculating the profit by subtracting the price at the left 
         * pointer from the price at the right pointer.
         * 
         * 4. If the calculated profit is greater than the maximum profit found so far, update the maximum 
         * profit.  
         * 
         * 5. If the price at the right pointer is less than the price at the left pointer, move the left 
         * pointer to the right to find a lower buying price.
         * 
         * 6. Repeat steps 3-5 until the right pointer reaches the end of the array.
         * 
         * 7. Return the maximum profit found.
         * 
         * Time complexity: O(n) because we are traversing the array once with the right pointer and once with the left pointer.
         * Space complexity: O(1) because we are using a constant amount of space to
         * 
         */

        int[] prices = {7,1,5,3,6,4};
        int result = maxProfit(prices);
        System.out.println("Max profit: " + result);

    }

}
