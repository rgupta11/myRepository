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

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        List<Boolean> arr = List.of(false,false,true,true,true);
        boolean target = true;
        int res = findBoundary(arr, target);
        System.out.println(res);
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
