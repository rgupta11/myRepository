package com.rga.q.twoPointer;

/**
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters 
 * and ignoring cases.
 * Approach: 
 * Two pointer approach, one at the beginning and one at the end, move towards each other 
 * and compare characters. If characters are not alphanumeric, skip them. If characters are different, 
 * return false.
 * space complexity: O(1) - we are using constant extra space for the pointers and temporary variables.
 * time complexity: O(n) - we are traversing the string at most once.
 */

public class Palindrome {

    // Function to check if a string is a palindrome
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true; // Empty string is considered a palindrome
        }
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            // Skip non-alphanumeric characters from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            
            // Skip non-alphanumeric characters from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            // Compare characters (case insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }

    // Test the palindrome function
    public static void main(String[] args) {
        String[] testStrings = {
            "A man a plan a canal Panama",
            "race a car",
            "hello",
            "Madam",
            "Was it a car or a cat I saw?"
        };
        
        for (String test : testStrings) {
            System.out.println("\"" + test + "\" is palindrome: " + isPalindrome(test));
        }
    }
}
