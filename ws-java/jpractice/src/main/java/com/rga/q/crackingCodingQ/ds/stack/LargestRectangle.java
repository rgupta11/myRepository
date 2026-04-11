package com.rga.q.ds.stack;

public class LargestRectangle {

    static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int n = heights.length;

        // Calculate area for each bar in the histogram
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        //maxarea = 

        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? n : n - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    /**
     * DESCRIPTION
     * Given an integer array heights representing the heights of histogram bars, 
     * write a function to find the largest rectangular area possible in a histogram, 
     * where each bar's width is 1.
     * 
     * input:
     * heights = [2,8,5,6,2,3]
     * output: 15
     * 
     * Approach:
     * 1. We can use a stack to keep track of the indices of the histogram bars.
     * 2. Iterate through the heights array:
     *   a. While the stack is not empty and the current height is less than the
     *  height of the bar at the top of the stack, pop the index from the stack and calculate the area of the rectangle formed by the height of the popped bar and the width determined by the current index and the index of the new top of the stack. Update the maximum area if necessary.
     *  b. Push the current index onto the stack.
     * 3. After iterating through the heights array, pop any remaining indices from the stack and calculate the area for each, updating the maximum area as needed.
     * 4. Return the maximum area found.
     * 
     * Time complexity: O(n) - Each index is pushed and popped from the stack at most once.
     * Space complexity: O(n) - In the worst case, the stack can hold all indices if the heights are in increasing order.
     * 
     */
    public static void main(String[] args){

        int[] heights = {2,8,5,6,2,3}; //output 15
        //int[] heights = {2,1,5,6,2,3}; //output  10
        int result = largestRectangleArea(heights);
        System.out.println(result); 

    }
    
}
