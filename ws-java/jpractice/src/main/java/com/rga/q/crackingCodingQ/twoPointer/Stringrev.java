package com.rga.q.twoPointer;


/**
 * Problem: Reverse Words in a String
 * Constraints:
 *    The sentence contains English uppercase and lowercase letters, digits, and spaces.
 *    There is at least one word in a sentence.
 *    1 ≤ sentence.length ≤ 10^4
 * 
 *  approach
 * * 1. Split the string into words using regex to handle multiple spaces.
 * * 2. Use a StringBuilder to construct the reversed string by iterating through the
 *   array of words in reverse order and appending them to the StringBuilder.
 * * 3. Trim the input string to remove leading and trailing spaces before splitting to ensure that we don't have empty strings in the array.
 * * 4. Finally, convert the StringBuilder to a String and return it.
 * 
 * stringbuilder vs string concatenation vs string join vs string buffer
 * StringBuilder is generally more efficient than string concatenation in a loop because it minimizes the number of intermediate String objects created.
 * String concatenation using the + operator creates a new String object each time, which can
 *  lead to increased memory usage and slower performance, especially in loops.
 * String.join is a convenient method for joining an array of strings with a specified delimiter,
 *  but it may not be as efficient as StringBuilder for large arrays or when the delimiter is not needed.
 * StringBuffer is similar to StringBuilder but is synchronized, making it thread-safe
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
