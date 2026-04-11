package com.rga.q.twoPointer;

import java.util.Arrays;

/** 
 * 
 * Write a function to count the number of triplets in an integer array nums that could form the sides of a triangle. For three sides to form a valid triangle, the sum of any two sides must be greater than the third side. The triplets do not need to be unique.
    Input: nums = [11,4,9,6,15,18]
    Output: 10
*/
public class TripletTriangle {
 
    public static int findTriplet(int[] arr){   
        Arrays.sort(arr);
        int counter = 0;

        for (int i=arr.length-1; i>=2; i--){
            int left = 0;
            int right = i - 1;

            while (left<right){
                if(arr[left] + arr[right] > arr[i]){
                    counter += right - left;
                    right--;
                }else{
                    left++;    
                }
            }
     }
            return counter;
    }

    public static void main(String[] args){
        int[] nums = {11,4,9,6,15,18};
        int result = findTriplet(nums);
        System.out.println("Number of valid triplets: " + result);
    }
}
