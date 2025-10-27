package com.rga.q.misc;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static Map<String, Integer> findTarget(int[] nums, int target) {

        Map <Integer, Integer> indices = new HashMap<Integer, Integer>();
        Map <String, Integer> returnI = new HashMap<String, Integer>();
        for (int i=0; i < nums.length; i++){
            int search = target - nums[i];
            if (indices.containsKey(search)){
                returnI.put("index1", indices.get(search));
                returnI.put("index2", i);
                return returnI;
            }else{
                indices.put(nums[i], i);
            }
        }
        return returnI;
    }


    public static void main (String[] args){
        
        int[] nums = {2,1,5,3};
        int target = 7;
        Map<String, Integer> result = findTarget(nums, target);
        System.out.println("Indices: " + result.get("index1") + ", " + result.get("index2"));

    } 

}

