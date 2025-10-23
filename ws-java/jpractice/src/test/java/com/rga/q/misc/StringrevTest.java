package com.rga.q.misc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Stringrev
 * Tests the reverseString method with various input scenarios
 */
public class StringrevTest {

    @Test
    @DisplayName("Test reversing a simple sentence")
    public void testReverseSimpleSentence() {
        String input = "Hello World";
        String expected = "World Hello";
        String actual = Stringrev.reverseString(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test reversing single word")
    public void testReverseSingleWord() {
        String input = "Hello";
        String expected = "Hello";
        String actual = Stringrev.reverseString(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test reversing string with multiple spaces")
    public void testReverseWithMultipleSpaces() {
        String input = "Hello    World    Java";
        String expected = "Java World Hello";
        String actual = Stringrev.reverseString(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test reversing string with leading and trailing spaces")
    public void testReverseWithLeadingTrailingSpaces() {
        String input = "  Hello World  ";
        String expected = "World Hello";
        String actual = Stringrev.reverseString(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test reversing empty string")
    public void testReverseEmptyString() {
        String input = "";
        String expected = "";
        String actual = Stringrev.reverseString(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test reversing string with only spaces")
    public void testReverseOnlySpaces() {
        String input = "   ";
        String expected = "";
        String actual = Stringrev.reverseString(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test reversing string with three words")
    public void testReverseThreeWords() {
        String input = "The quick brown";
        String expected = "brown quick The";
        String actual = Stringrev.reverseString(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test reversing string with punctuation")
    public void testReverseWithPunctuation() {
        String input = "Hello, World!";
        String expected = "World! Hello,";
        String actual = Stringrev.reverseString(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test reversing string with numbers")
    public void testReverseWithNumbers() {
        String input = "Java 11 is great";
        String expected = "great is 11 Java";
        String actual = Stringrev.reverseString(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test reversing string with mixed case")
    public void testReverseWithMixedCase() {
        String input = "HeLLo WoRLd";
        String expected = "WoRLd HeLLo";
        String actual = Stringrev.reverseString(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test reversing long sentence")
    public void testReverseLongSentence() {
        String input = "The quick brown fox jumps over the lazy dog";
        String expected = "dog lazy the over jumps fox brown quick The";
        String actual = Stringrev.reverseString(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test reversing string with special characters")
    public void testReverseWithSpecialCharacters() {
        String input = "Hello @world #java";
        String expected = "#java @world Hello";
        String actual = Stringrev.reverseString(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test reversing string with tabs and spaces")
    public void testReverseWithTabsAndSpaces() {
        String input = "Hello\t\tWorld\tJava";
        String expected = "Java World Hello";
        String actual = Stringrev.reverseString(input);
        assertEquals(expected, actual);
    }
}
