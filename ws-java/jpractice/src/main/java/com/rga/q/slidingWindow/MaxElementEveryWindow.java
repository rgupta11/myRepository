package com.rga.q.slidingWindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxElementEveryWindow {
    
    static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // Remove indices whose corresponding values are less than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // Add current index to the deque
            deque.offer(i);
            // If we've processed at least k elements, add the maximum to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        

        /**
         * Find the maximum element in every sliding window of size k
         * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
         * Output: [3,3,5,5,6,7]
         * Approach:
         * 1. Use a deque to store indices of elements in the current window.
         * 2. For each element in the array:
         *    a. Remove indices from the front of the deque if they are out of the current window.
         *    b. Remove indices from the back of the deque if their corresponding elements are smaller than the current element.
         *    c. Add the current index to the back of the deque.
         * 3. If we have processed at least k elements, add the maximum element (front of deque) to result.
         * 
         * Example walkthrough:
         * nums = [1,3,-1,-3,5,3,6,7], k = 3
         * Step 1: Process first 3 elements
         * i = 0, deque = [0] (1)
         * i = 1, deque = [1] (3) - remove index 0 because 3 > 1
         * i = 2, deque = [1, 2] (3, -1) - remove index 2 because -1 < 3
         * Step 2: 
         * Add max element for first window [1,3,-1] -> max = 3
         * i = 3, deque = [1, 3] (3, -3) - remove index 3 because -3 < 3
         * 
         * Step 3: 
         * Add max element for second window [3,-1,-3] -> max = 3
         * i = 4, deque = [4] (5) - remove indices 1 and 3 because 5 > 3 and 5 > -3
         * 
         * Step 4:
         * Add max element for third window [-1,-3,5] -> max = 5 
         * i = 5, deque = [4, 5] (5, 3) - remove index 5 because 3 < 5
         * 
         * Step 5:
         * Add max element for fourth window [-3,5,3] -> max = 5
         * i = 6, deque = [4, 6] (5, 6) - remove index 4 because 6 > 5
         * 
         * Step 6:
         * Add max element for fifth window [5,3,6] -> max = 6
         * i = 7, deque = [7] (7) - remove index 6 because 7 > 6
         * 
         * Step 7:
         * Add max element for sixth window [3,6,7] -> max = 7
         * Output: [3,3,5,5,6,7]
         * 
         * Complexity:
         * Time: O(n) - Each element is added and removed from the deque at most once.
         * Space: O(k) - The deque can hold at most k indices.
         * 
         *
         * 
         */
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println("Max elements in each sliding window of size " + k + ": " + Arrays.toString(result));

    }
}
