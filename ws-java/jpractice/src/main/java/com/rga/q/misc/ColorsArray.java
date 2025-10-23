package com.rga.q.misc;

public class ColorsArray {
    
    
    public static int[] sortColors (int[] colors) {

        int low=0, mid=0, high=colors.length-1;
        while (mid <= high) {
            switch(colors[mid]){
                case 0:
                    swap(colors, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(colors, mid, high);
                    high--;
                    break;
                case 3:
                    swap(colors, mid, high);
                    high--;
                    break;
                default:
                    //swap(colors, mid, high);
                    //high--;
                    mid++;
                    break;
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
