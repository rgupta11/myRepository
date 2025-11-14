package com.rga.q.misc;

import java.util.ArrayList;
import java.util.List;

public class scratchpad {
    
    public void testMethod(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int low =0; 
        int high, mid;
        high = list.get(list.size() - 1);
        mid = low + high / 2;
        System.out.println("low: " + low + " mid: " + mid + " high: " + high);
    }


    
}
