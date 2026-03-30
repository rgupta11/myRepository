package com.rga.q.slidingWindow;

public class SmallestSubString {
    
    static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Count characters in t
        int[] charCount = new int[128]; // Assuming ASCII
        for (char c : t.toCharArray()) {
            charCount[c]++;
        }

        int left = 0, right = 0, count = t.length();
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (charCount[rightChar] > 0) {
                count--;
            }
            charCount[rightChar]--;
            right++;

            while (count == 0) { // All characters are included
                if (right - left < minLength) {
                    minLength = right - left;
                    minStart = left;
                }
                char leftChar = s.charAt(left);
                charCount[leftChar]++;
                if (charCount[leftChar] > 0) {
                    count++;
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
    /**
     * Find the smallest substring in S containing all characters of T.
     * Example:
     * S = "ADOBECODEBANC", T = "ABC"
     * Output: "BANC"   
     * 
     * Approach:
     * 1. Use two pointers to create a sliding window.
     * 2. Use a hash map to count the characters in T and their required counts
     * 3. Expand the right pointer to include characters until all characters in T are included in the window.
     * 4. Once all characters are included, try to shrink the window from the left
     * 5. Update the minimum window size and starting index whenever a valid window is found.
     * 6. Continue this process until the right pointer reaches the end of S.
     * 7. Return the minimum window substring or an empty string if no such window exists.
     * 
     * Time complexity: O(n) where n is the length of S, because each character is visited at most twice (once by the right pointer and once by the left pointer).
     * Space complexity: O(m) where m is the number of unique characters in T,
     * because we need to store the count of characters in T in a hash map.
     * 
     
     * 
     */
    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow(s, t);
        System.out.println("Smallest substring containing all characters of T: " + result); // Output: "BANC"
        
    }
}
