package com.rga.q.misc;

public class Palindrome {


    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                // write your code here
                return false;
            }

            left++;
            right--;
        }

        return true;
    }


    public static void main(String[] args) {
        String testString = "A man, a plan, a canal: Panama";
        System.out.println("Is palindrome: " + isPalindrome(testString));
    }
}
