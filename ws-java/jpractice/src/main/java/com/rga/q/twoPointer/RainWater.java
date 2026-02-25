package com.rga.q.twoPointer;


/**
 * Container With Most Water 
 * [Two-pointers are generally perceived to work on sorted arrays and that's a common pattern, 
 * but not a strict rule. Two-pointer works whenever we can eliminate possibilities by moving 
 * pointers intelligently.]
 * 
 * DESCRIPTION
 * Given an array heights where each element represents the height of a vertical line, 
 * pick two lines to form a container. Return the maximum area (amount of water) the container can hold.
 * 
 * What is area? Width × height, where width is the distance between walls, and height is the shorter wall 
 * (water overflows at the shorter wall).
 * 
 * Width: How far apart the two walls are (right_index - left_index)
 * Height: The shorter wall's height (min(heights[left], heights[right]))
 * Area = wxh
 * 
 * Approach: Two Pointer Technique
 * 1. Initialize two pointers, left at the beginning of the array and right at the end of the array.
 * While left < right
 * ......
 * if (heights[left] < heights[right]) {
 *       left++;
 *   } else {
 *       right--;
 *   }
 * 
 * 
 */
public class RainWater {
    public static int trapWater(int[] height) {
        int left = 0, right = height.length - 1;
        int waterTrapped = 0;


        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int currWaterTrapped = width * minHeight;
            waterTrapped = Math.max(waterTrapped, currWaterTrapped);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return waterTrapped;
    }

    public static void main(String[] args) {
        //int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        //int[] height = {3,4,1,2,2,4,1,3,2};
        int[] height =  {3, 4, 1, 2, 2, 5, 1, 0, 2};
        int result = trapWater(height);
        System.out.println("Max water trapped: " + result);
    }
}
