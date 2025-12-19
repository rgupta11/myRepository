package com.rga.q.crackingCodingQ;

import java.util.Arrays;

public class MainJ {

    /**
     * Unique String
     * Implement an algorithm to determine if a string has all unique characters. 
     * What if you can not use additional data structures?
     */
    static boolean checkUnique(String str){
        
        char[] chars = sortStringToChar(str);
        boolean dup = false;
        for (int i=0; i<chars.length; i++){
            if (i+1 != chars.length && chars[i] == chars[i+1]){ //IMPROVE in future
                dup = true;
                break;                   
            }    
        }
        if(dup){
            System.out.println("String has duplicate chars");
        }else{
            System.out.println("String has unique chars");
        }
        return dup;
    }

    //String Sorting
    static char[] sortStringToChar(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return chars;

    }

    static String sortString(String str){
        char[] chars = sortStringToChar(str);
        return new String(chars);
    }
    
    /** 
     * Replace spaces in a string with %20
    */
    static String replaceSpaces(String str, String replaceWith){
        String[] strings = str.split("\\s+");
        StringBuilder strB = new StringBuilder();
        for(String s: strings){
            strB.append(s + replaceWith);
        }
        return strB.toString();
    }


    public static void main( String args[]) {
        
        /*
         * Unique String
         * Implement an algorithm to determine if a string has all unique characters. 
         * What if you can not use additional data structures?
         */
        //String str = "abcfghiseqlafps";
        String str = "abcdefghilsy";
        checkUnique(str);

        /** 
         * Find if 2 strings are Anagrams
         * sort both words and compare if they are equal then they are anagrams
         */
        String str1 = "waterbottle";
        String str2 = "erbottlewat";
        if(sortString(str1).equals(sortString(str2))) {
            System.out.println("Strings " + str1 + " and " + str2 + " are anagrams");
        } else {
            System.out.println("Strings " + str1 + " and " + str2 + " are not anagrams");
        }   
        
        
        /** 
         * Replace spaces in a string with %20
         */
        String str3 = "Mr John Smith    ";
        System.out.println("Original String: '" + str3 + "'");
        System.out.println("Modified String: '" + replaceSpaces(str3, "%20") + "'");
        //using replace all 
        System.out.println("Modified String: '" + str3.trim().replaceAll("\\s+", "%20") + "'");


        /*
            Assume you have a method isSubstring which checks if one word is a 
            substring of another. Given two strings, s1 and s2, write code to check 
            if s2 is a rotation of s1 using only one call to isSubstring 
            (i.e., 'waterbottle' is a rotation of 'erbottlewat').

            Same as anagrams 
        */

        // if sorted s1 & s2 are equal ||     

    }

    
}
