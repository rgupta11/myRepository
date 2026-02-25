package com.rga.q.twoPointer;

/**
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
 */
public class TwoSum {


    static boolean checkTwoSum(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while (left<right) { 
            int sum = nums[left] + nums[right];
            if(sum == target){
                return true;            
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;

    }

    static void findAllPairs(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while (left<right) { 
            int sum = nums[left] + nums[right];
            if(sum == target){
                System.out.println(nums[left] + ", " + nums[right]);
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        int target = 9;
        
        // Test case 1: Pair exists that sums to target
        boolean result = checkTwoSum(nums, target);
        System.out.println("Two sum result: " + result);

        //Find all pairs that sum to target
        System.out.println("All pairs that sum to target:");
        findAllPairs(nums, target);

    }
    
}
