package com.rga.q.twoPointer;

/**
 * Given an integer array nums, write a function to rearrange the array by moving all zeros to the end while keeping the order of non-zero elements unchanged. Perform this operation in-place without creating a copy of the array.
    Input:

nums = [2,0,4,0,9]
Output:

[2,4,9,0,0]
 */
public class MoveZeros {
    
    public static int[] move(int[] arr){

        int swapPos = 0;
        for (int i=0; i<arr.length-1; i++){
            if(arr[i]!=0){
                //swap
            }
        }
        return arr;
    }
}
