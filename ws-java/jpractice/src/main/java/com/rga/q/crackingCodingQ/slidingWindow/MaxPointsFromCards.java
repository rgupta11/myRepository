package com.rga.q.slidingWindow;

public class MaxPointsFromCards {


    /**
     * Medium 
     * 
     * Given an array of integers representing card values, write a function to calculate the maximum score 
     *  you can achieve by picking exactly k cards.
     * You must pick cards in order from either end. You can take some cards from the beginning, 
     *  then switch to taking cards from the end, but you cannot skip cards or pick from the middle.
     
     * For example, with k = 3:
     * Take the first 3 cards: valid
     * Take the last 3 cards: valid
     * Take the first card, then the last 2 cards: valid
     * Take the first 2 cards, then the last card: valid
     * Take card at index 0, skip some, then take card at index 5: not valid (skipping cards)
     * 
     * 
     * Category: Sliding Window problem because we are looking for a contiguous sequence of cards from 
     *  either end of the array that maximizes the score.
     * 
     * Approach:
     * 1. Calculate the total sum of all card values.
     * 2. Find the minimum sum of a subarray of size (n - k), where n is the length of the array.
     * 3. Subtract this minimum sum from the total sum to get the maximum score.  
     * 4. This works because picking k cards from either end is equivalent to leaving out (n - k) cards in the middle,
     *     and we want to minimize the sum of those left out cards to maximize the score
     * 5. Since conditions like below are also valid why we did not considered them in our approach because we are looking for the maximum score and these conditions will not give us the maximum score.
     *  Take the first card, then the last 2 cards: valid
     *  Take the first 2 cards, then the last card: valid
     * 
     * Time complexity: O(n) because we need to calculate the total sum and find the minimum subarray sum.
     * Space complexity: O(1) because we are using a constant amount of space to
     * store the total sum, current sum, and minimum sum.
     * 
     * Example:
     * cards = [2,11,4,5,3,9,2]
     * k = 3
     * Total sum = 2 + 11 + 4 + 5 + 3 + 9 + 2 = 36
     * We need to find the minimum sum of a subarray of size (7 - 3) = 4  
     *  why 4 because we are picking 3 cards, so we are leaving out 4 cards in the middle.  
     * Subarrays of size 4: [2,11,4,5], [11,4,5,3], [4,5,3,9], [5,3,9,2]
     *  why condition - Take the first card, then the last 2 cards is not considered
     * Sums of these subarrays: 22, 23, 21, 19
     * Minimum sum = 19
     * Maximum score = Total sum - Minimum sum = 36 - 19 = 17
     * Output: 17
     * 
     * 
     */
    
    static int getMaxPointsFromCards(int[] cards, int k){
        int totalSum = 0;
        for(int card : cards){
            totalSum += card;
        }

        int minSum = Integer.MAX_VALUE;
        int currentSum = 0;
        int left = 0;
        int n = cards.length;   
        for(int right = 0; right < n; right++){
            currentSum += cards[right];

            if(right - left + 1 == n - k){
                minSum = Math.min(minSum, currentSum);
                currentSum -= cards[left];
                left++;
            }
        }
        return totalSum - minSum;
        
        /**
         * Example walkthrough:
         * cards = [2,11,4,5,3,9,2];
         * k = 3
         * 
         * Step 1: Calculate total sum
         * totalSum = 2 + 11 + 4 + 5 + 3 + 9 + 2 = 36
         * 
         * Step 2: Find minimum sum of subarray of size (n - k) = 4 
         * Subarrays of size 4: [2,11,4,5], [11,4,5,3], [4,5,3,9], [5,3,9,2]
         * Sums of these subarrays: 22, 23, 21, 19
         * Minimum sum = 19
         * 
         * Step 3: Calculate maximum score
         * Maximum score = Total sum - Minimum sum = 36 - 19 = 17
         * Output: 17   
         */
    }
    
    public static void main(String[] args) {
        
        //int[] cards = {2,11,4,5,3,9,2};
        int[] cards = new int[]{1, 100, 10, 0, 4, 5, 6};
        int k = 3;
        int result = getMaxPointsFromCards(cards, k);
        System.out.println("Maximum points from cards: " + result);
    }
    
}
