package com.rga.q.crackingCodingQ.twoPointer;

import java.util.Arrays;    
import java.util.List;
import java.util.Set;
import java.util.HashSet;



/**
 * Write a function to count the number of triplets in an integer array nums that could form the sides of a triangle.
 * For three sides to form a valid triangle, all three of these conditions must hold:
 * (a + b > c), (a + c > b), and (b + c > a), where (a), (b), and (c) are the side lengths.
 * In other words, the sum of every possible pair must exceed the third side.
 * 
 * Input - nums = [11,4,9,6,15,18]
 * Output 10
 * triplets are (4,6,9), (4,6,11), (4,6,15), (4,6,18), (4,9,11), (4,9,15), (4,9,18), (6,9,11), (6,9,15), (6,9,18)   
 * 
 * Approach:
 * 1. Sort the array in non-decreasing order.
 * sorted array - [4,6,9,11,15,18]
 * 2. Use 2 pointers to find the triplets.
 * 3. Iterate through the array from the end and fix the last element as i. 
 *  Then use two pointers to find pairs (l, r) such that l+r > i.
 * 4. If l+r > i, then all elements from l to r-1 will also satisfy the condition because the array is sorted.
 * 5. Move the pointers accordingly and count the valid triplets.
 * 
 * Data structure to store triplets - list of triplets
 * Example List of triplets: (4,6,9), (4,6,11), (4,6,15), (4,6,18), (4,9,11), (4,9,15), (4,9,18), (6,9,11), (6,9,15), (6,9,18)
 * 
 * duplicate triplets - if the input array has duplicate elements, we can have duplicate triplets.
 * For example, if the input array is [4,6,9,11,15,18,4], we can have duplicate triplets like (4,6,9) and (4,6,9) again.
 * To avoid duplicate triplets, we can use a set to store the triplets and check for duplicates before adding them to the set.
 * e.g. 
 * 
 * Time complexity: O(n^2) due to the nested loop and two pointers.
 */
public class Triangles {


    static int countValidTriangles(int[] nums) {
        int count = 0;
        int n = nums.length;

        // Step 1: Sort the array
        Arrays.sort(nums);
        Set<List<Integer>> triplets = new HashSet<>(); // To store unique triplets

        // Step 2: Use two pointers to find valid triplets
        for (int i = n - 1; i >= 2; i--) {
            int l = 0; // left pointer
            int r = i - 1; // right pointer

            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    // If nums[l] + nums[r] > nums[i], then all elements from l to r-1 will also satisfy the condition
                    count += (r - l);
                    // Add the triplet to the set to avoid duplicates
                    triplets.add(Arrays.asList(nums[l], nums[r], nums[i]));
                    r--; // Move the right pointer leftwards
                } else {
                    l++; // Move the left pointer rightwards
                }
            }
        }
        System.out.println("Unique triplets that can form triangles: " + triplets);
        return count;
    }

    public static void main(String[] args){

        /**
         * Write a function to count the number of triplets in an integer array nums that could form the sides
         * of a triangle and also find the triplets.
         * For three sides to form a valid triangle, all three of these conditions must hold: 
         * (a + b > c), (a + c > b), and (b + c > a), 
         * where (a), (b), and (c) are the side lengths.
         * In other words, the sum of every possible pair must exceed the third side.
         * 
         * Input - nums = [11,4,9,6,15,18]
         * Output 
         * 10, 
         * triplets are (4,6,9), (4,6,11), (4,6,15), (4,6,18), (4,9,11), (4,9,15), (4,9,18), (6,9,11), (6,9,15), (6,9,18)
         * 
         * Approach:
         * 1. Sort the array in non-decreasing order.
         * 2. Use 2 pointers to find the triplets.
         * 3. Iterate through the array from the end and fix the last element as i. 
         *  Then use two pointers to find pairs (l, r) such that l+r > i.
         * 4. If l+r > i, then all elements from l to r-1 will also satisfy the condition because the array is sorted.
         * 5. Move the pointers accordingly and count the valid triplets.
         *
         *
         * Time complexity: O(n^2) due to the nested loop and two pointers.
         * Space complexity: O(1) if we don't consider the space used by sorting.
         * 
         */

        int[] nums = {11,4,9,6,15,18};
        //int[] nums = {4,6,9,11,15,18,4};
        int count = countValidTriangles(nums);
        System.out.println("Number of valid triangles: " + count);
        
    }
    
}
