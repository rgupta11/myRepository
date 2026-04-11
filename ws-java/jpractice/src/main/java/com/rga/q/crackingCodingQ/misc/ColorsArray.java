package com.rga.q.misc;

public class ColorsArray {
    
    
    public static int[] sortColors (int[] colors) {
        // Create a copy to avoid modifying during iteration
        int[] temp = colors.clone();
        
        // First pass: collect all valid colors (0, 1, 2) in order they appear
        int writeIndex = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0 || temp[i] == 1 || temp[i] == 2) {
                colors[writeIndex++] = temp[i];
            }
        }
        
        // Second pass: collect all invalid colors and place them at the end
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0 && temp[i] != 1 && temp[i] != 2) {
                colors[writeIndex++] = temp[i];
            }
        }
        
        // Third pass: sort the valid colors portion using Dutch National Flag
        int validLength = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0 || temp[i] == 1 || temp[i] == 2) {
                validLength++;
            }
        }
        
        int low = 0, mid = 0, high = validLength - 1;
        
        while (mid <= high) {
            if (colors[mid] == 0) {
                swap(colors, low, mid);
                low++;
                mid++;
            } else if (colors[mid] == 1) {
                mid++;
            } else if (colors[mid] == 2) {
                swap(colors, mid, high);
                high--;
                // Don't increment mid here as we need to check the swapped element
            } else {
                // This shouldn't happen in the valid portion
                mid++;
            }
        }
        
        return colors;
    }

    private static void swap(int[] colrs, int pos1, int pos2){
        int temp = colrs[pos1];
        colrs[pos1] = colrs[pos2];
        colrs[pos2] = temp;
    }


    /*
     * 0- Red
     * 1- White
     * 2- Blue
     */
    public static void main(String[] args) {
        int[] colors = {2, 0, 2, 1, 1, 0,0,2,2,1,1,0,3};
        int[] sortedColors = sortColors(colors);
        
        System.out.print("[");
        for (int color : sortedColors) {
            System.out.print(color + " ");
        }
        System.out.print("]");
    }
}
