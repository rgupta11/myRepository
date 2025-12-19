package com.rga.q.twoPointer;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place 
 * so that objects of the same color are adjacent, with the colors in the order 
 * red, white, and blue.    
 * 
 * [2,1,2,0,1,0,1,0,1] --> [0,0,0,1,1,1,1,2,2]
 * 
 */
public class SortColors {
    
    public static void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {//when 0 then swap with left
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
                i++;
            } else if (nums[i] == 2) {//when 2 then swap with right
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,2,0,1,0,1,0,1};
        sortColors(arr);
        for (int i : arr) {
            System.out.print(i);    
        }
    }
}
