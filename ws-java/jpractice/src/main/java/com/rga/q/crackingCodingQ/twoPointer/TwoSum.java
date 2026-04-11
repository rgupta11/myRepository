package com.rga.q.twoPointer;
import java.util.HashSet;
import java.util.Set;



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
 * Datastructure to store pairs - set of pairs to avoid duplicates
 * example: [1,2,3,4,5,6,7,8], target = 9
 * Set of pairs: (1,8), (2,7), (3,6), (4,5)
 * Java code to find all pairs that sum to target:
 * 
 */
public class TwoSum {


    static class Pair<T, U> {
        private T first;
        private U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (!first.equals(pair.first)) return false;
            return second.equals(pair.second);
        }

        @Override
        public int hashCode() {
            int result = first.hashCode();
            result = 31 * result + second.hashCode();
            return result;
        }
    }


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

    static Set findAllPairs(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        Set<Pair<Integer, Integer>> pairs = new HashSet<>();
        while (left<right) { 
            int sum = nums[left] + nums[right];
            if(sum == target){
                System.out.println(nums[left] + ", " + nums[right]);
                pairs.add(new Pair<>(nums[left], nums[right]));
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        int target = 9;
        
        // Test case 1: Pair exists that sums to target
        boolean result = checkTwoSum(nums, target);
        System.out.println("Two sum result: " + result);

        //Find all pairs that sum to target
        System.out.println("All pairs that sum to target:");
        Set<Pair<Integer, Integer>> pairs = findAllPairs(nums, target);
        for (Pair<Integer, Integer> pair : pairs) {
            System.out.println("(" + pair.getFirst() + ", " + pair.getSecond() + ")");
        }

    }
    
}
