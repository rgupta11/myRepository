package com.rga.q.misc;

import java.util.HashSet;
import java.util.Set;

/*
 * Longest Substring Without Repeating Characters
 * Uses Sliding window technique
 * 
 * Given the length of String find the longest substring without repeating characters
 * Array of characters to be considered:
 */
public class LongestSubstring {
    
    public static char[] findMaxSubString(char[] str){

        Set<Character> charSet = new HashSet<>();
        int leftP = 0;
        int rightP = 0;
        char[] maxSubStr = new char[str.length];
        int maxLength = 0;

        while(rightP < str.length){

            //if char already present, shrink window from left till char is removed
            if (charSet.contains(str[rightP])){
                while (str[leftP] != str[rightP]){
                    charSet.remove(str[leftP]);
                    leftP++;
                }
                //move left pointer one step ahead to remove duplicate char
                charSet.remove(str[leftP]);
                leftP++;
            } else {
                //add char to set
                charSet.add(str[rightP]);
                //update max substring if required
                if (charSet.size() > maxLength){
                    maxLength = charSet.size();
                    //update max substring
                    int index = 0;
                    for (int i=leftP; i <= rightP; i++){
                        maxSubStr[index++] = str[i];
                    }
                }
            }
            //expand window by moving right pointer
            rightP++;
        }

        return maxSubStr;

    }

}
