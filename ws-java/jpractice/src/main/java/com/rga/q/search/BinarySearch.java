package com.rga.q.search;

import java.util.List;

class BinarySearch {
    public static int binarySearch(List<Integer> arr, int target) {
        // WRITE YOUR BRILLIANT CODE HERE
        if(arr == null || arr.size() == 0 
           || target > arr.get(arr.size() -1) 
           || target < arr.get(0))
            return -1;
        
        int mid, high, low=0;
        high = arr.size() -1;
        
        while(low <= high){
            mid = (int) Math.ceil((low+high)/2);
            if(arr.get(mid) == target){
                return mid;
            }else if(arr.get(mid) < target){
                //move high to mid
                low = mid + 1;
            }else if(arr.get(mid) > target){
                //move low to mid
                high = mid - 1;
            }
        }    
        return -1;
    }

    /* 
    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    } 
    */

    public static void main(String[] args) {
        List<Integer> arr = List.of(1, 2, 3, 4, 5);
        int target = 3;
        int res = binarySearch(arr, target);
        System.out.println(res);
    }
}