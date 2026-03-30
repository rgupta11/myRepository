package com.rga.q.slidingWindow;

public class MaxSumSubArray {


    static int getMaxSumSubArray(int[] nums, int k){
        int maxSum = 0;
        int currentSum = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++){
            currentSum += nums[right];

            if(right - left + 1 == k){
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= nums[left];
                left++;
            }
        }
        return maxSum;
    }
    public static void main(String[] args){


        /**
         * Easy 
         * Given an array of integers nums and an integer k, 
         * find the maximum sum of any contiguous subarray of size k.
         * 
         * Input nums = [2, 1, 5, 1, 3, 2]
         * k = 3
         * Output 9
         * Explanation: Subarray with maximum sum is [5, 1, 3].
         * 
         * Category sliding window problem because we are looking for a contiguous subarray of size k 
         * and we want to find the maximum sum of that subarray.
         * 
         * Approach: 
         * 1. Initialize two pointers, left and right, to the beginning of the array.
         * 2. Initialize a variable to keep track of the current sum of the subarray and a variable 
         *      to keep track of the maximum sum found so far.
         * 3. Move the right pointer to the right, adding the value at the right pointer to the current sum 
         *      until the size of the subarray (right - left + 1) is equal to k.
         * 4. Once the size of the subarray is equal to k, compare the
         *      current sum with the maximum sum found so far and update the maximum sum if necessary.
         * 5. Move the left pointer to the right, subtracting the value at the
         *      left pointer from the current sum, and repeat steps 3-5 until the right pointer 
         *      reaches the end of the array.
         * 6. Return the maximum sum found.
         * 
         * Complexity analysis:
         * Time complexity: O(n) because we are traversing the array once with the right pointer and once with the left pointer.
         * Space complexity: O(1) because we are using a constant amount of space to store the current sum and maximum sum.
         * 
         * 
         */

        
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int result = getMaxSumSubArray(nums, k);
        System.out.println("Max sum of subarray of size " + k + " is: " + result);

    }
}
    
