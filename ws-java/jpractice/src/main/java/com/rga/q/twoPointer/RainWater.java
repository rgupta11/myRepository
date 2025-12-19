package com.rga.q.twoPointer;

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
