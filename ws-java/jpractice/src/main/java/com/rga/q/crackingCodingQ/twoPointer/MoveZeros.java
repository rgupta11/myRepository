package com.rga.q.crackingCodingQ.twoPointer;
/**
 * Given an integer array nums, write a function to rearrange the array by moving all zeros to the end 
 * while keeping the order of non-zero elements unchanged. Perform this operation in-place without 
 * creating a copy of the array.
    Input:

nums = [2,0,4,0,9]
Output:

[2,4,9,0,0]
Complexity Analysis:
Time Complexity: O(n), where n is the length of the input array. We traverse the array twice: once to move non-zero elements and once to fill the remaining positions with zeros.
Space

why cant we sort the array? -- order of non-zero elements would not be maintained
Sorting the array would not maintain the relative order of the non-zero elements. The problem specifically requires
that the order of non-zero elements remains unchanged. If we sort the array, all zeros would be grouped together, and the non-zero elements would be rearranged, 
which violates the requirement of maintaining their original order.
 */

//suggest a better class name for this problem - MoveZerosToEnd
public class MoveZeros {
    
    public static int[] move(int[] arr){

        int nonZeroIndex = 0; // Pointer for the position of the next non-zero element

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                // If the current element is non-zero, move it to the nonZeroIndex position
                arr[nonZeroIndex] = arr[i];
                nonZeroIndex++;
            }
        }

        // Fill the remaining positions with zeros
        for (int i = nonZeroIndex; i < arr.length; i++) {
            arr[i] = 0;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2,0,4,0,9};
        int[] result = move(arr);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
