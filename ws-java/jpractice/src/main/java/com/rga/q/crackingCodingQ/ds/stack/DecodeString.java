package com.rga.q.ds.stack;

import java.util.Stack;


public class DecodeString {

    static String decodeString(String s) {
        StringBuilder currentString = new StringBuilder();
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // Build the number k
                System.out.println(ch+"-"+k);
            } else if (ch == '[') {
                // Push the current string and count onto the stacks
                stringStack.push(currentString.toString());
                countStack.push(k);
                // Reset current string and k for the new segment
                currentString.setLength(0);
                k = 0;
            } else if (ch == ']') {
                // Pop the last string and count
                String lastString = stringStack.pop();
                int count = countStack.pop();
                // Repeat the current string 'count' times and concatenate with lastString
                StringBuilder temp = new StringBuilder(lastString);
                for (int i = 0; i < count; i++) {
                    temp.append(currentString);
                }
                currentString = temp; // Update currentString to the newly formed string
            } else {
                currentString.append(ch); // Append regular characters to currentString
            }
        }

        return currentString.toString(); // The fully decoded string
    }   

    public static void main(String[] args){

        /**
         * Given an encoded string, write a function to return its decoded string that follows a specific 
         * encoding rule: k[encoded_string], where the encoded_string within the brackets is repeated 
         * exactly k times. Note that k is always a positive integer. The input string is well-formed 
         * without any extra spaces, and square brackets are properly matched. Also, assume that the 
         * original data doesn't contain digits other than the ones that specify the number of times to 
         * repeat the following encoded_string.
         * 
         * s = "3[a2[c]]"
         * Output: "accaccacc"
         * 
         * Approach:
         * 1. Use a stack to keep track of the current string and the number of times it needs to be repeated.
         * 2. Iterate through each character in the input string:
         *    a. If the character is a digit, calculate the full number (in case of multiple digits) and push it onto the stack.
         *    b. If the character is an opening bracket '[', push the current string onto the stack and reset the current string to empty.  
         *    c. If the character is a closing bracket ']', pop the last string and the number from the stack, and repeat the current string accordingly, then concatenate it with the popped string.
         *    d. If the character is a letter, append it to the current string.
         * 3. After processing all characters, the current string will contain the fully decoded string, which can be returned.
         * 
         * Time complexity: O(n * k) where n is the length of the input string and k is the maximum number of repetitions, 
         * because in the worst case, we might have to repeat a string k times for each character in the input.
         * 
         * space complexity: O(n) for the stack and the current string, where n is the length of the input string.
         * 
         */

        String s = "30[a2[c]]";
        String result = decodeString(s);
        System.out.println("Decoded string: " + result); // Should print "accaccacc

    }
    
}
