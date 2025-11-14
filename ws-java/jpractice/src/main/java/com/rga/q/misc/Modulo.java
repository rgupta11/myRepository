package com.rga.q.misc;

/**
 * The rule to calculate x % y is:
 * if x < y, return x
 * else subtract y from x until x < y
 */
public class Modulo {
    
    public static int mod(int x, int y) {
        // Security fix: Handle division by zero upfront
        if (y == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        
        // Handle negative divisors
        if (y < 0) {
            throw new IllegalArgumentException("Negative divisor not supported in this implementation");
        }
        
        // Handle negative dividend properly for mathematical correctness
        if (x < 0) {
            // For negative numbers, use built-in modulo to ensure correct mathematical behavior
            return x % y;
        }
        
        // Original algorithm for positive numbers
        while (x >= y) {
            x -= y;
        }
        return x;
    }

    public static void main(String[] args) {
        try {
            System.out.println("Testing modulo implementation:");
            System.out.println("mod(10, 3) = " + mod(10, 3));  // Output: 1
            System.out.println("mod(20, 5) = " + mod(20, 5));  // Output: 0
            System.out.println("mod(7, 4) = " + mod(7, 4));    // Output: 3
            System.out.println("mod(15, 6) = " + mod(15, 6));  // Output: 3
            
            // Test edge cases
            System.out.println("\nTesting edge cases:");
            try {
                System.out.println("mod(10, 0) = " + mod(10, 0));
            } catch (ArithmeticException e) {
                System.out.println("Expected error for division by zero: " + e.getMessage());
            }
            
            try {
                System.out.println("mod(10, -3) = " + mod(10, -3));
            } catch (IllegalArgumentException e) {
                System.out.println("Expected error for negative divisor: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}
