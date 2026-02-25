package com.rga.q;

import java.util.List;

import javax.swing.text.DateFormatter;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {


    public static void main(String[] args) {
        

        //arr[0]-- [0->1 1->2]
        //arr[1]-- [0->4 1->3]
        //...
        //arr[4] -- [0->2, 1->3, 2->6, 3->7, 4->8]
        int[][] arr = {{1,2}, {4,3}, {6,4}, {3,2}, {2,3,6,7,8}};
        System.out.println(arr[4][4]);


        int[][] jagged = new int[3][]; // Initialize rows only
        jagged[0] = new int[2];        // Row 0 has 2 columns
        jagged[1] = new int[5];        // Row 1 has 5 columns
        jagged[2] = new int[3];        // Row 2 has 3 columns


        int[][] matrix = {
        {1, 2, 3}, // Row 0
        {4, 5, 6}, // Row 1
        {7, 8, 9}  // Row 2
        };

        int[] ar = {1,2,3,4,5};

        int a = 5;
        int b = 10;

        System.out.println(Math.abs(a - b)); // Result: 5
        System.out.println(Math.abs(b - a)); // Result: 5

        int[][][] arr3D = {
            {
                {1,2,3,4},
                {1,5,6,7},
                {4,2,7,9}
            },
            {
                {6,4,3,2},
                {8,2,9,4},
                {1,0,5,3}
            }
        };

        System.out.println(arr3D[0][0][2]);
    
        //??Q - sort an N-Dimension Array

        //custom comparator for sorting Dat[] in List<>
        List<Date[]> intervals = new ArrayList<Date[]>(); 

        intervals.add(new Date[]{new Date(), new Date()});
        intervals.add(new Date[]{new Date(), new Date()});

        intervals.sort((x,y) -> x[0].compareTo(y[0]));

        String ts1 = "25-02-2026 18:58:00";
        String ts2 = "25-02-2026 19:00:00";
        String ts3 = "25-02-2026 19:15:00";
        String ts4 = "25-02-2026 19:20:00";

        String pattern = "dd-mm-yyyy hh:mm:ss";
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        intervals.add(new Date[]{new Date(df.format(ts1)), new Date(df.format(ts2))});
        intervals.add(new Date[]{new Date(df.format(ts3)), new Date (df.format(ts4))});

    }    
}
