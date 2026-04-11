package com.rga.q.slidingWindow;

import java.util.HashSet;
import java.util.Set;


/**
 * Write a function to return the length of the longest substring in a provided string s where 
 * all characters in the substring are distinct.
 * 
 * Example 1: Input: s = "eghghhgg"
 * Output: 3
 * 
 * 
 * Approach:
 * Category - Sliding Window because we are looking for a contiguous substring and we want to 
 *  find the longest substring with distinct characters.
 * 
 * 1. Initialize two pointers, left and right, to the beginning of the string.
 * 2. Initialize a variable to keep track of the maximum length of the substring found so far and a 
 *      Set to keep track of the distinct characters in the current substring.
 * 3. Move the right pointer to the right, adding the character at the right pointer to the Set 
 *      until we encounter a duplicate character.
 * 4. Once we encounter a duplicate character, move the left pointer to the right, removing the character 
 *      at the left pointer from the Set until we have removed the duplicate character.
 * 5. After each iteration, compare the length of the current substring (right - left) with the 
 *      maximum length found so far and update the maximum length if necessary.
 * 6. Return the maximum length found.
 * 
 * Time complexity: O(n) because we are traversing the string once with the right pointer and once with the left pointer.
 * Space complexity: O(min(m, n)) where m is
*/
public class MaxSubtring {
    public static int getMaxSubString(String str){
        int maxLength = 0;
        int left = 0, right = 0;
        Set<Character> charSet = new HashSet<Character>();
        for(int i=0; i<str.length(); i++){
            if(!charSet.contains(str.charAt(i))){
                charSet.add(str.charAt(i));
                right++;
            }else{
                left++;
                charSet.remove(str.charAt(i));
            }
            maxLength = Math.max(maxLength, right-left);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "eghghhggabcde";
        int result = getMaxSubString(str);
        System.out.println("Max substring length: " + result);
    }
}
