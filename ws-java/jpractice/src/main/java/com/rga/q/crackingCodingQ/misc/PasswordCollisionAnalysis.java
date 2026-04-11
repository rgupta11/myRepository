package com.rga.q.misc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Analysis of collision probability for SecureRandomEx password generator
 * Passwords are 16 characters long, chosen from a set of 87 characters
 * logic based on the birthday paradox
 * Pseudo logic 
 * - Total possible passwords = (character set size)^(password length)
 * - For n generated passwords, collision probability P(collision) ≈ 1 - e^(-n²/2N)
 *   where N = total possible passwords
 * - Calculate and print collision probabilities for various n values
 * - Determine n where P(collision) reaches 50%
 */
public class PasswordCollisionAnalysis {

    // Character set sizes from SecureRandomEx
    private static final int UPPER_SIZE = 26;    // A-Z
    private static final int LOWER_SIZE = 26;    // a-z  
    private static final int DIGITS_SIZE = 10;   // 0-9
    private static final int SPECIAL_SIZE = 25;  // !@#$%^&*()-_=+[]{};:,.<>?
    
    private static final int TOTAL_CHARSET_SIZE = UPPER_SIZE + LOWER_SIZE + DIGITS_SIZE + SPECIAL_SIZE; // 87
    private static final int PASSWORD_LENGTH = 16;

    public static void main(String[] args) {
        System.out.println("=== Password Collision Probability Analysis ===\n");
        
        // Calculate total possible passwords
        BigInteger totalPossiblePasswords = calculateTotalPossiblePasswords();
        System.out.printf("Character set size: %d\n", TOTAL_CHARSET_SIZE);
        System.out.printf("Password length: %d\n", PASSWORD_LENGTH);
        System.out.printf("Total possible passwords: %s\n", formatBigNumber(totalPossiblePasswords));
        System.out.printf("Total possible passwords (scientific): %.2e\n\n", 
                         new BigDecimal(totalPossiblePasswords).doubleValue());

        // Analyze collision probabilities for different numbers of generated passwords
        analyzeCollisionProbability(totalPossiblePasswords, 1_000);
        analyzeCollisionProbability(totalPossiblePasswords, 10_000);
        analyzeCollisionProbability(totalPossiblePasswords, 100_000);
        analyzeCollisionProbability(totalPossiblePasswords, 1_000_000);
        analyzeCollisionProbability(totalPossiblePasswords, 10_000_000);
        analyzeCollisionProbability(totalPossiblePasswords, 100_000_000);

        // Calculate 50% collision probability threshold
        calculateBirthdayParadoxThreshold(totalPossiblePasswords);
        
        // Real-world scenarios
        System.out.println("\n=== Real-World Scenarios ===");
        realWorldScenarios(totalPossiblePasswords);
    }

    private static BigInteger calculateTotalPossiblePasswords() {
        return BigInteger.valueOf(TOTAL_CHARSET_SIZE).pow(PASSWORD_LENGTH);
    }

    private static void analyzeCollisionProbability(BigInteger totalPasswords, long numGenerated) {
        double probability = calculateCollisionProbability(totalPasswords, numGenerated);
        
        System.out.printf("Generating %,d passwords:\n", numGenerated);
        System.out.printf("  Collision probability: %.2e (%.10f%%)\n", 
                         probability, probability * 100);
        
        if (probability < 1e-20) {
            System.out.println("  Risk level: NEGLIGIBLE - Practically impossible");
        } else if (probability < 1e-10) {
            System.out.println("  Risk level: EXTREMELY LOW");
        } else if (probability < 1e-5) {
            System.out.println("  Risk level: VERY LOW");
        } else if (probability < 0.01) {
            System.out.println("  Risk level: LOW");
        } else if (probability < 0.1) {
            System.out.println("  Risk level: MODERATE");
        } else {
            System.out.println("  Risk level: HIGH");
        }
        System.out.println();
    }

    private static double calculateCollisionProbability(BigInteger totalPasswords, long numGenerated) {
        // Using birthday paradox approximation: P(collision) ≈ 1 - e^(-n²/2N)
        // where n = number of passwords generated, N = total possible passwords
        
        if (numGenerated <= 1) return 0.0;
        
        BigDecimal n = BigDecimal.valueOf(numGenerated);
        BigDecimal N = new BigDecimal(totalPasswords);
        
        // Calculate n²/2N
        BigDecimal nSquared = n.multiply(n);
        BigDecimal denominator = N.multiply(BigDecimal.valueOf(2));
        BigDecimal exponent = nSquared.divide(denominator, 50, RoundingMode.HALF_UP);
        
        // For very large numbers, use approximation
        if (exponent.compareTo(BigDecimal.valueOf(50)) > 0) {
            return 1.0; // Essentially certain collision
        }
        
        // Calculate e^(-n²/2N)
        double exp = Math.exp(-exponent.doubleValue());
        return 1.0 - exp;
    }

    private static void calculateBirthdayParadoxThreshold(BigInteger totalPasswords) {
        System.out.println("=== Birthday Paradox Analysis ===");
        
        // Calculate when collision probability reaches 50%
        // Solve for n in: 0.5 = 1 - e^(-n²/2N)
        // n ≈ sqrt(2N * ln(2)) ≈ sqrt(1.386 * N)
        
        BigDecimal N = new BigDecimal(totalPasswords);
        BigDecimal factor = BigDecimal.valueOf(1.386); // 2 * ln(2)
        BigDecimal product = N.multiply(factor);
        
        // Calculate square root using Newton's method for very large numbers
        BigDecimal sqrt = sqrt(product, 50);
        
        System.out.printf("50%% collision probability at: %s passwords\n", formatBigNumber(sqrt.toBigInteger()));
        System.out.printf("50%% threshold (scientific): %.2e\n", sqrt.doubleValue());
    }

    private static void realWorldScenarios(BigInteger totalPasswords) {
        System.out.println("Small company (1,000 users): ");
        analyzeCollisionProbability(totalPasswords, 1_000);
        
        System.out.println("Medium company (10,000 users): ");
        analyzeCollisionProbability(totalPasswords, 10_000);
        
        System.out.println("Large enterprise (100,000 users): ");
        analyzeCollisionProbability(totalPasswords, 100_000);
        
        System.out.println("Global service (10 million users): ");
        analyzeCollisionProbability(totalPasswords, 10_000_000);
        
        System.out.println("Major platform (1 billion passwords): ");
        analyzeCollisionProbability(totalPasswords, 1_000_000_000L);
    }

    private static String formatBigNumber(BigInteger number) {
        String str = number.toString();
        if (str.length() <= 15) {
            return String.format("%,d", number);
        }
        return str.substring(0, 3) + "..." + str.substring(str.length() - 3) + 
               " (" + str.length() + " digits)";
    }

    // Newton's method for square root of very large numbers
    private static BigDecimal sqrt(BigDecimal value, int scale) {
        if (value.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        
        BigDecimal x0 = BigDecimal.ZERO;
        BigDecimal x1 = BigDecimal.valueOf(Math.sqrt(value.doubleValue()));
        
        MathContext mc = new MathContext(scale + 10, RoundingMode.HALF_UP);
        
        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = value.divide(x0, mc).add(x0).divide(BigDecimal.valueOf(2), mc);
        }
        
        return x1.setScale(scale, RoundingMode.HALF_UP);
    }
}
