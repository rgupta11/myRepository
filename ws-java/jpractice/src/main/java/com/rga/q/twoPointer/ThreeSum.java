package com.rga.q.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem:
 * 
 * Given an input integer array nums, write a function to find all unique triplets 
 * [nums[i], nums[j], nums[k]] such that i, j, and k are distinct indices, 
 * and the sum of nums[i], nums[j], and nums[k] equals zero. Ensure that the resulting list 
 * does not contain any duplicate triplets.
 * 
 * The order of the triplets and the order of the elements within the triplets do not matter.
 * 
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * 
 * Approach:
 * 1. Sort the input array to facilitate the two-pointer technique and handle duplicates.
 * 2. Iterate through the sorted array, fixing one element and using two pointers to find pairs that sum to the negative of the fixed element.
 * 3. Skip duplicate elements to avoid duplicate triplets in the result.
 * 4. Move the left and right pointers inward based on the sum of the three elements.
 * 5. Continue this process until all unique triplets that sum to zero are found.
 * 
 * 
 */
public class ThreeSum {
    
    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array

        for (int i = 0; i < nums.length - 2; i++) { // Step 2: Iterate through the array
            if (i > 0 && nums[i] == nums[i - 1]) { // Skip duplicate elements
                continue;
            }
            int left = i + 1; // Two pointers
            int right = nums.length - 1;

            while (left < right) { // Step 4: Move pointers inward
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right])); // Found a triplet
                    left++;
                    right--;

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++; // Need a larger sum
                } else {
                    right--; // Need a smaller sum
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println("Result: " + result);
    }
}
