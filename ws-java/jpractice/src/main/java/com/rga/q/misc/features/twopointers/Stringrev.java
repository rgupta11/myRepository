package com.rga.q.misc.features.twopointers;


/**
 * Problem: Reverse Words in a String
 * Constraints:
 *    The sentence contains English uppercase and lowercase letters, digits, and spaces.
 *    There is at least one word in a sentence.
 *    1 ≤ sentence.length ≤ 10^4
 * 
 * 
 */
public class Stringrev {
    
    public static String reverseString(String str) {

        //null/empty str check
        if(str == null || str.length() == 0)
            return str;
        //regex pattern to split by spaces
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
