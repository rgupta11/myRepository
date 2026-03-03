package com.rga.q.ds.stack;

import java.util.Stack;

/**
 * follow the Last-In, First-Out (LIFO) principle. The last element added to the stack will be the first one to be removed.
 * Common operations on a stack include:
 * 1. Push: Adding an element to the top of the stack.
 * 2. Pop: Removing the top element from the stack.
 * 3. Peek: Viewing the top element of the stack without removing it.
 * 4. IsEmpty: Checking if the stack is empty.
 * 5. Size: Getting the number of elements in the stack.
 * Stacks are commonly used in various applications such as:
 * 1. Function Call Management: Stacks are used to manage function calls in programming languages
 * 2. Expression Evaluation: Stacks are used to evaluate expressions, especially in infix, postfix, and prefix notations.
 * 3. Backtracking Algorithms: Stacks are used in algorithms that involve backtracking, such as depth-first search (DFS) in graphs.
 * 4. Undo Mechanisms: Stacks are used to implement undo functionality in applications, allowing users to revert to previous states.
 * 
 * 
 */
public class Paranthesis {
    

    /**
     * Edge cases to consider:
     * 1. Empty string: An empty string is considered valid.
     * 2. Single type of brackets: Strings like "((()))" or "{{{}}}" are valid.
     * 3. Mixed types of brackets: Strings like "({[]})" are valid, while "({)}" is not.
     * 4. Unmatched brackets: Strings like "(((" or "(()" are not valid.
     * 5.. Incorrect order: Strings like "([)]" are not valid.
     * 6. Only closing brackets: Strings like ")))" are not valid.
     * 7. Only opening brackets
     * ...
     */
    static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        java.util.Map<Character, Character> mapping = new java.util.HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (char c : s.toCharArray()) {
            if (mapping.containsKey(c)) { // If it's a closing bracket
                char topElement = stack.isEmpty() ? '#' : stack.pop(); // Get the top element or a dummy value if stack is empty
                if (topElement != mapping.get(c)) { // Check if it matches the corresponding opening bracket
                    return false;
                }
            } else { // If it's an opening bracket, push it onto the stack
                stack.push(c);
            }
        }

        return stack.isEmpty(); // Return true if stack is empty, false otherwise
    }
    
    static int longestValidParentheses(String s) {
        
        Stack<Integer> stack = new Stack<>();
        java.util.Map<Character, Character> mapping = new java.util.HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');      
        mapping.put(']', '[');

        stack.push(-1); // Base index for valid substring
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mapping.containsKey(c)) { // If it's a closing bracket
                stack.pop(); // Pop the last index
                //check if its popped element is not opening bracket, then push current index as base for next valid substring
                if (stack.isEmpty()) {
                    stack.push(i); // Push current index as base for next valid substring
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek()); // Update max length
                }
            } else { // If it's an opening bracket, push its index onto the stack
                stack.push(i);  
             }
            
        }
       

        return maxLength;
    }

    public static void main(String[] args) {
        
        /**
         * Valid Parentheses
         * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
         * An input string is valid if:
         * Open brackets must be closed by the same type of brackets.
         * Open brackets must be closed in the correct order.
         * Every close bracket has a corresponding open bracket of the same type.
         * 
         * Input: s = "(){({})}"
         * Output: true
         * 
         * Approach:
         * 1. Use a stack to keep track of opening brackets.
         * 2. crate a mapping of closing brackets to their corresponding opening brackets for easy lookup.
         * 3. Iterate through each character in the string:
         *  a. If the character is an opening bracket, push it onto the stack.
         *  b. If the character is a closing bracket, check if the stack is empty or if the top of the stack does not match the corresponding opening bracket. If either condition is true, return false.
         * 4. After processing all characters, check if the stack is empty. If it is empty, return true; otherwise, return false.
         * 
         */

        System.out.println(isValidParentheses("(){({})}")); // Should print true
        System.out.println(isValidParentheses("(]"));       // Should print false

        /**
         * Longest valid parenthesis
         * 
         * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
         * Example 1:
         * Input: s = "(()"
         * Output: 2
         * Explanation: The longest valid parentheses substring is "()"
         * 
         * Approach:
         * 1. Use a stack to keep track of the indices of the characters in the string.
         * 2. Initialize the stack with a base index of -1 to handle edge cases where the valid substring starts from index 0.
         * 3. Iterate through each character in the string:
         *  a. If the character is '(', push its index onto the stack.
         *  b. If the character is ')', pop the top index from the stack. If the stack is empty after popping, 
         * push the current index onto the stack as a new base index. If the stack is not empty, 
         * calculate the length of the current valid substring by subtracting the current index from the top of 
         * the stack.
         * 4. Keep track of the maximum length of valid parentheses found during the iteration.
         * 5. Return the maximum length after processing all characters.
         *
         * 
         */
        System.out.println(longestValidParentheses("(()")); // Should print 2
        System.out.println(longestValidParentheses(")()())")); // Should print 4

    }

}
