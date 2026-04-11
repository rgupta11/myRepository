package com.rga.q.misc;

public class Stringrev {
    
    public static String reverseString(String str) {

        //empty str check

        String[] nw = str.trim().split("\\s+");
        StringBuilder revString = new StringBuilder();
        for(int i=nw.length-1; i>=0; i--){
            revString.append(nw[i]);
            if(i != 0)
                revString.append(" ");
        }
        return revString.toString();
    }

    public static void main(String[] args) {
        String str = "Hello, World!";
        String reversed = reverseString(str);
        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reversed);
    }
}
