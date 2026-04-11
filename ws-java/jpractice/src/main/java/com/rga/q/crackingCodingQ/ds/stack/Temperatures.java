package com.rga.q.ds.stack;

public class Temperatures {
    
    /**
     * timecomplexity: O(n) - Each index is pushed and popped from the stack at most once.
     * How is it O(n) as I see 2 loops? 
     * The outer loop iterates through each element in the temps array, which takes O(n) time. 
     * The inner while loop can also iterate through the stack, but each index is pushed and popped 
     * at most once. Therefore, the total number of operations for both loops combined is 
     * O(n) + O(n) = O(n).
     * Space Complexity: O(n) - In the worst case, the stack can hold all indices if the temperatures are in decreasing order.
     * 
     */
    static int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] answer = new int[n]; //defaults all values to 0
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        return answer;
    }   

    /**
     * Description
     * Given an integer array temps representing daily temperatures, write a function to 
     * calculate the number of days one has to wait for a warmer temperature after each given day. 
     * The function should return an array answer where answer[i] represents the wait time for a warmer day 
     * after the ith day. If no warmer day is expected in the future, set answer[i] to 0.
     * 
     * input: 
     * temps = [65, 70, 68, 60, 55, 75, 80, 74]
     * output: [1, 4, 3, 2, 1, 1, 0, 0]
     * 
     * Approach:
     * 1. Use a stack to keep track of the indices of the days for which we haven't found a warmer temperature yet.
     * 2. Iterate through the temps array:
     *   a. While the stack is not empty and the current temperature is greater than the
     *    temperature at the index on the top of the stack, pop the index from the stack and calculate the number of days waited for a warmer temperature by subtracting the popped index from the current index. Update the answer array at the popped index with this value.
     *  b. Push the current index onto the stack.
     * 3. After iterating through the temps array, any indices left in the stack will have an answer of 0, which is already initialized in the answer array.
     * 4. Return the answer array.
     * 
     * Time Complexity: O(n) - Each index is pushed and popped from the stack at most once.
     * Space Complexity: O(n) - In the worst case, the stack can hold all indices if the temperatures are in decreasing order.
     * 
     * 
     */
    public static void main(String[] args){
        int[] temps = {65, 70, 68, 60, 55, 75, 80, 74};
        int[] result = dailyTemperatures(temps);
        System.out.println(java.util.Arrays.toString(result)); // Should print [1, 4, 3, 2, 1, 1, 0, 0]
    
    }
}
