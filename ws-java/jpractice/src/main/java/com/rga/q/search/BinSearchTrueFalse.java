package com.rga.q.search;

import java.util.Arrays;
import java.util.List;

class BinSearchTrueFalse {
    public static int findBoundary(List<Boolean> list, boolean target) {
        
        if(list == null || list.size() == 0)    
            return -1;

        int high, low=0;
        int mid, boundary=-1;
        high = list.size() - 1;

        while (low <= high){
            mid = low + (high - low) / 2; // Proper integer division to avoid overflow
            if(list.get(mid) == target){
                boundary = mid;
                high = mid - 1; // Continue searching left to find the first occurrence
            }else if(target && !list.get(mid)){ // If target is true and current is false
                low = mid + 1; // Search right half
            }else if(!target && list.get(mid)){ // If target is false and current is true  
                high = mid - 1; // Search left half
            }else{
                // This shouldn't happen in a well-formed boolean array, but handle gracefully
                high = mid - 1;
            }
        }
        return boundary;
        
    }

    public static int findBoundaryInt(List<Integer> list, int target) {
        
        if(list == null || list.size() == 0)    
            return -1;

        int high, low=0;
        int mid, boundary=-1;
        high = list.size() - 1;

        while (low <= high){
            mid = low + (high - low) / 2; // Proper integer division to avoid overflow
            if(list.get(mid) == target){
                boundary = mid;
                high = mid - 1; // Continue searching left to find the first occurrence
            }else if(target > list.get(mid)){ // If target is greater than current
                low = mid + 1; // Search right half
            }else if(target < list.get(mid)){ // If target is less than current
                high = mid - 1; // Search left half
            }else{
                // This shouldn't happen in a well-formed boolean array, but handle gracefully
                high = mid - 1;
            }
        }
        return boundary;
        
    }

    public static void main(String[] args) {
        List<Boolean> arr = List.of(false,false,true,true,true);
        boolean target = true;
        int res = findBoundary(arr, target);
        System.out.println(res);


        List<Integer> list = List.of(1, 3, 3, 3, 3, 6, 10, 10, 10, 100);
        int target2 = 3;
        int res2 = findBoundaryInt(list, target2);
        System.out.println(res2);

    }

    /*
     if(list == null || list.size() == 0)    
            return -1;

        int high, low=0;
        int mid, boundry=-1;
        high = list.size() - 1;

        while (low <= high){
            mid = (int) Math.ceil((low+high)/2);
            if(list.get(mid) == Boolean.TRUE ){
                boundry = mid;
                high = mid-1;
            }else
                low = mid+1;           
        }
        return boundry;
     */
}
