package com.rga.q.misc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for Modulo class
 * Tests cover normal operations, edge cases, and security aspects
 */
@DisplayName("Modulo Class Test Suite")
public class ModuloTest {

    @Test
    @DisplayName("Test basic modulo operations")
    public void testModBasicCases() {
        assertEquals(1, Modulo.mod(10, 3), "10 % 3 should equal 1");
        assertEquals(0, Modulo.mod(20, 5), "20 % 5 should equal 0");
        assertEquals(2, Modulo.mod(8, 3), "8 % 3 should equal 2");
        assertEquals(0, Modulo.mod(0, 5), "0 % 5 should equal 0");
        assertEquals(4, Modulo.mod(4, 5), "4 % 5 should equal 4");
    }

    @Test
    @DisplayName("Test division by zero throws ArithmeticException")
    public void testModDivisionByZero() {
        ArithmeticException exception = assertThrows(
            ArithmeticException.class,
            () -> Modulo.mod(10, 0),
            "Division by zero should throw ArithmeticException"
        );
        assertEquals("Division by zero is not allowed", exception.getMessage(),
            "Exception message should match expected text");
    }

    @Test
    @DisplayName("Test negative divisor throws IllegalArgumentException")
    public void testModNegativeDivisor() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> Modulo.mod(10, -3),
            "Negative divisor should throw IllegalArgumentException"
        );
        assertEquals("Negative divisor not supported in this implementation", exception.getMessage(),
            "Exception message should match expected text");
    }

    @Test
    @DisplayName("Test when dividend is less than divisor")
    public void testModXLessThanY() {
        assertEquals(2, Modulo.mod(2, 5), "2 % 5 should equal 2");
        assertEquals(0, Modulo.mod(0, 1), "0 % 1 should equal 0");
        assertEquals(3, Modulo.mod(3, 7), "3 % 7 should equal 3");
    }

    @Test
    @DisplayName("Test large numbers for performance")
    public void testModLargeNumbers() {
        assertEquals(5, Modulo.mod(1000005, 1000000), "1000005 % 1000000 should equal 5");
        assertEquals(3, Modulo.mod(1000003, 1000), "1000003 % 1000 should equal 3");
    }
    
    @Test
    @DisplayName("Test when dividend equals divisor")
    public void testModEqualValues() {
        assertEquals(0, Modulo.mod(5, 5), "5 % 5 should equal 0");
        assertEquals(0, Modulo.mod(10, 10), "10 % 10 should equal 0");
        assertEquals(0, Modulo.mod(1, 1), "1 % 1 should equal 0");
        assertEquals(0, Modulo.mod(100, 100), "100 % 100 should equal 0");
    }
    
    @Test
    @DisplayName("Test modulo with divisor of 1")
    public void testModWithOne() {
        assertEquals(0, Modulo.mod(5, 1), "5 % 1 should equal 0");
        assertEquals(0, Modulo.mod(100, 1), "100 % 1 should equal 0");
        assertEquals(0, Modulo.mod(0, 1), "0 % 1 should equal 0");
        assertEquals(0, Modulo.mod(1, 1), "1 % 1 should equal 0");
    }

    @Test
    @DisplayName("Test additional edge cases")
    public void testModEdgeCases() {
        assertEquals(1, Modulo.mod(7, 2), "7 % 2 should equal 1");
        assertEquals(1, Modulo.mod(15, 7), "15 % 7 should equal 1");
        assertEquals(6, Modulo.mod(13, 7), "13 % 7 should equal 6");
    }

    @Test
    @DisplayName("Test consistency with Java's built-in modulo operator")
    public void testConsistencyWithBuiltInModulo() {
        // Test various combinations to ensure consistency
        int[] dividends = {10, 15, 23, 50, 100};
        int[] divisors = {3, 7, 11, 17};
        
        for (int dividend : dividends) {
            for (int divisor : divisors) {
                int expected = dividend % divisor;
                int actual = Modulo.mod(dividend, divisor);
                assertEquals(expected, actual,
                    String.format("Custom modulo should match built-in: %d %% %d", dividend, divisor));
            }
        }
    }
}