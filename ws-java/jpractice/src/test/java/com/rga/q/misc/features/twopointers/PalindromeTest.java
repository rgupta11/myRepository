package com.rga.q.misc.features.twopointers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Palindrome
 * Tests the isPalindrome method with various input scenarios
 */
public class PalindromeTest {

    @Test
    @DisplayName("Test basic palindrome - single word")
    public void testBasicPalindrome() {
        assertTrue(Palindrome.isPalindrome("racecar"));
        assertTrue(Palindrome.isPalindrome("madam"));
        assertTrue(Palindrome.isPalindrome("level"));
    }

    @Test
    @DisplayName("Test palindrome with mixed case")
    public void testPalindromeWithMixedCase() {
        assertTrue(Palindrome.isPalindrome("RaceCar"));
        assertTrue(Palindrome.isPalindrome("MadAm"));
        assertTrue(Palindrome.isPalindrome("Level"));
    }

    @Test
    @DisplayName("Test palindrome with spaces and punctuation")
    public void testPalindromeWithSpacesAndPunctuation() {
        assertTrue(Palindrome.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(Palindrome.isPalindrome("Was it a car or a cat I saw?"));
    }

    @Test
    @DisplayName("Test palindrome with numbers and letters")
    public void testPalindromeWithNumbersAndLetters() {
        assertTrue(Palindrome.isPalindrome("A1B2b1a"));
        assertTrue(Palindrome.isPalindrome("12321"));
        assertTrue(Palindrome.isPalindrome("1a2b2a1"));
    }

    @Test
    @DisplayName("Test non-palindrome strings")
    public void testNonPalindrome() {
        assertFalse(Palindrome.isPalindrome("hello"));
        assertFalse(Palindrome.isPalindrome("world"));
        assertFalse(Palindrome.isPalindrome("java"));
        assertFalse(Palindrome.isPalindrome("programming"));
    }

    @Test
    @DisplayName("Test non-palindrome with spaces and punctuation")
    public void testNonPalindromeWithSpacesAndPunctuation() {
        assertFalse(Palindrome.isPalindrome("race a car"));
        assertFalse(Palindrome.isPalindrome("hello world"));
        assertFalse(Palindrome.isPalindrome("A man, a plan, a canal: Not Panama"));
    }

    @Test
    @DisplayName("Test empty string")
    public void testEmptyString() {
        assertTrue(Palindrome.isPalindrome(""));
    }

    @Test
    @DisplayName("Test single character")
    public void testSingleCharacter() {
        assertTrue(Palindrome.isPalindrome("a"));
        assertTrue(Palindrome.isPalindrome("A"));
        assertTrue(Palindrome.isPalindrome("1"));
        assertTrue(Palindrome.isPalindrome("!"));
    }

    @Test
    @DisplayName("Test string with only non-alphanumeric characters")
    public void testOnlyNonAlphanumericCharacters() {
        assertTrue(Palindrome.isPalindrome("!!!"));
        assertTrue(Palindrome.isPalindrome(".,!"));
        assertTrue(Palindrome.isPalindrome("   "));
        assertTrue(Palindrome.isPalindrome("@#$%^&*()"));
    }

    @Test
    @DisplayName("Test palindrome with special characters")
    public void testPalindromeWithSpecialCharacters() {
        assertTrue(Palindrome.isPalindrome("Madam, I'm Adam"));
        assertTrue(Palindrome.isPalindrome("No 'x' in Nixon"));
        assertTrue(Palindrome.isPalindrome("Mr. Owl ate my metal worm"));
    }

    @Test
    @DisplayName("Test complex palindromes")
    public void testComplexPalindromes() {
        assertTrue(Palindrome.isPalindrome("Able was I ere I saw Elba"));
        assertTrue(Palindrome.isPalindrome("A Santa at NASA"));
        assertTrue(Palindrome.isPalindrome("Do geese see God?"));
    }

    @Test
    @DisplayName("Test palindrome with numbers only")
    public void testNumbersPalindrome() {
        assertTrue(Palindrome.isPalindrome("12321"));
        assertTrue(Palindrome.isPalindrome("1001"));
        assertTrue(Palindrome.isPalindrome("7"));
        assertFalse(Palindrome.isPalindrome("123"));
        assertFalse(Palindrome.isPalindrome("1234"));
    }

    @Test
    @DisplayName("Test long palindromes")
    public void testLongPalindromes() {
        assertTrue(Palindrome.isPalindrome("abcdefghijklmnopqrstuvwxyzzyxwvutsrqponmlkjihgfedcba"));
        assertTrue(Palindrome.isPalindrome("abcdefedcba"));
    }

    @Test
    @DisplayName("Test edge case - two characters")
    public void testTwoCharacters() {
        assertTrue(Palindrome.isPalindrome("aa"));
        assertTrue(Palindrome.isPalindrome("11"));
        assertFalse(Palindrome.isPalindrome("ab"));
        assertFalse(Palindrome.isPalindrome("12"));
    }
}
