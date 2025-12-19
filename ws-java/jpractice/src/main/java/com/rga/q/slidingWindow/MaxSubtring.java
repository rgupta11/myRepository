package com.rga.q.slidingWindow;

import java.util.HashSet;
import java.util.Set;


/**
 * Write a function to return the length of the longest substring in a provided string s where all characters in the substring are distinct.

Example 1: Input: s = "eghghhgg"
Output: 3
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
