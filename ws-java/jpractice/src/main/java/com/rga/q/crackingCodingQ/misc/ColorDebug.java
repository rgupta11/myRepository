package com.rga.q.misc;

import java.util.Arrays;

public class ColorDebug {
    public static void main(String[] args) {
        // Test the specific failing case
        int[] input = {2, 0, 3, 1, 5, 0, 2};
        System.out.println("Input: " + Arrays.toString(input));
        
        int[] result = ColorsArray.sortColors(input.clone());
        System.out.println("Result: " + Arrays.toString(result));
        
        // Count valid colors
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        for (int color : input) {
            if (color == 0) zeroCount++;
            else if (color == 1) oneCount++;
            else if (color == 2) twoCount++;
        }
        
        System.out.println("Zeros: " + zeroCount + ", Ones: " + oneCount + ", Twos: " + twoCount);
        System.out.println("Expected order: 0s[0-" + (zeroCount-1) + "], 1s[" + zeroCount + "-" + (zeroCount+oneCount-1) + "], 2s[" + (zeroCount+oneCount) + "-" + (zeroCount+oneCount+twoCount-1) + "]");
        
        // Print what's actually at each position
        for (int i = 0; i < result.length; i++) {
            System.out.println("Position " + i + ": " + result[i]);
        }
    }
}
