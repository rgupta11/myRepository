package com.rga.q.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return all numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Example:
 * Input: nums = [2,7,11,-2], target = 9 
 * output [(2,7), (11,-2)]
 */
public class TwoSum {

    public static Map<Integer, Integer> findTarget(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                result.put(nums[i], complement);
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main (String[] args){
        
        int[] nums = {2,1,5,6};
        int target = 7;
        Map<Integer, Integer> result = findTarget(nums, target);
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            System.out.print("[" + entry.getKey() + ", " + entry.getValue() + "]");
        }

    } 

}

