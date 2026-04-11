package com.rga.q.misc;

import java.util.Arrays;

public class ColorsArray2 {
    
    public static void sortColors(int[] arr, int n) {
        // Positions where next occurrence of color[k] should go
        int[] pos = new int[n + 1];
        
        // First pass: find counts
        for (int num : arr) {
            pos[num]++;
        }

        // Make pos[i] hold starting index for each color
        for (int i = 1; i <= n; i++) {
            pos[i] += pos[i - 1];
        }

        // Second pass: in-place reassignment using single traversal
        int i = 0;
        while (i < arr.length) {
            int correctColor = findColor(pos, arr[i]);
            int targetIndex = pos[arr[i] - 1];
            
            if (i >= targetIndex && i < pos[arr[i]]) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[targetIndex];
                arr[targetIndex] = temp;
            }
        }
    }

    private static int findColor(int[] pos, int value) {
        for (int i = 0; i < pos.length; i++) {
            if (value < pos[i]) return i;
        }
        return pos.length - 1; // fallback
    }

    public static void main(String[] args) {
        int[] colors = {2, 0, 3, 1, 4, 2, 0, 3};
        int n = 4; // Max color value

        System.out.println("Original: " + Arrays.toString(colors));
        sortColors(colors, n);
        System.out.println("Sorted:   " + Arrays.toString(colors));
    }
}

