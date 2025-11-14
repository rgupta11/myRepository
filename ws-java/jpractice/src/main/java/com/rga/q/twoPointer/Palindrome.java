package com.rga.q.twoPointer;

/*
 * For example, to identify whether a string is a palindrome, 
 * we can use one pointer to iterate the string from the beginning and the other
 * pointer to iterate from the end.
 * They move towards each other and stop when they meet in the middle of the string.
 * This algorithm runs in O(n) time and uses O(1) space.
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
