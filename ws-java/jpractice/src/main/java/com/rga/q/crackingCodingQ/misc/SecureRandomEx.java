package com.rga.q.misc;

import java.security.SecureRandom;

public class SecureRandomEx {
    
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{};:,.<>?";

    private static final String ALL = UPPER + LOWER + DIGITS + SPECIAL;

    private static final SecureRandom RANDOM = new SecureRandom();


    public static String generate(int length) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(ALL.length());
            sb.append(ALL.charAt(index));
        }

        return sb.toString();
    }
    public static boolean checkRandom(String password){
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for(char ch: password.toCharArray()){
            if(UPPER.indexOf(ch) >= 0) hasUpper = true;
            else if(LOWER.indexOf(ch) >= 0) hasLower = true;
            else if(DIGITS.indexOf(ch) >= 0) hasDigit = true;
            else if(SPECIAL.indexOf(ch) >= 0) hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public static void main(String[] args) {
        String password = "";
        int counter = 100;
        while (counter > 0){
           password = generate(16);
           if(checkRandom(password))
               break;
           counter--;
        }
        System.out.println("Generated Password: " + password);
    }
}


