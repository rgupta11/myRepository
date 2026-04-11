package com.rga.q.twoPointer;



/**
 * Two Pointer Technique -  two-pointer technique leverages the fact that the input array is sorted.
 * 
 * This technique refers to using two pointers that start at opposite ends of an array 
 * and gradually move towards each other.
 * 
 * Types of problem for the technique
 * - Two Sum
 * - Container with most water
 * - Valid Palindrome
 * - Reverse String
 * 
 * 
 * Two sum
 * Given a sorted array of integers nums, determine if there exists a pair of numbers that sum to a given target.
 * Example 1:
 * Input: nums = [1,2,3,4,5], target = 9
 * Output: true
 * Explanation: The pair (4, 5) sums to 9.
 * 
 * Approach: Single pass O(n) time complexity
 * 1. Initialize two pointers, left at the beginning of the array and right at the end of the array.
 * 2. While left pointer is less than right pointer:
 *   a. Calculate the sum of the elements at left and right pointers.
 *   b. If the sum is equal to the target, return true.
 *   c. If the sum is less than the target, increment the left pointer. 
 *   d. If the sum is greater than the target, decrement the right pointer.
 * 
 * Modification - find all pairs that sum to target
 * Approach: Create a lookup for the elements in the array and iterate through the array to 
 * find pairs that sum to target.
 * 
 * 
 * 
 */
public class Theory {
    
}
