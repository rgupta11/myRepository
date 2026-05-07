package com.rga.q.crackingCodingQ.twoPointer;
import java.util.Arrays;


/**
 * Write a function to sort a given integer array nums in-place 
 * (and without the built-in sort function), where the array contains n integers
 * 
 * Example:
 * Input: nums = [64, 34, 25, 12, 22, 11, 90]
 * Output: [11, 12, 22, 25, 34, 64, 90] 
 * 
 * Follow-up: Can you implement an efficient sorting algorithm with a time complexity of O(n log n) and a space complexity of O(1)?
 * 
 * Approach:
 * 1. We can use the Quick Sort algorithm, which has an average time complexity of O(n log n) and a space complexity of O(1) when implemented in-place. 
 * 2. The Quick Sort algorithm works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot.
 * 3. The sub-arrays are then sorted recursively. This can be done in-place, requiring only O(log n) space for the recursive stack.
 * 4. The choice of
 */
public class IntegerSorting {
    

    public static void main(String[] args) {
        int[] nums = {64, 34, 25, 12, 22, 11, 90};
        // Call the sorting function here and print the sorted array
        quickSort(nums, 0, nums.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(nums));

    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }   

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
