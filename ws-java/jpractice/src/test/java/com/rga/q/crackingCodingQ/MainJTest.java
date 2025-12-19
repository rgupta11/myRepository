package com.rga.q.crackingCodingQ;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MainJTest {

    @Test
    public void testCheckUnique_UniqueChars() {
        assertFalse(MainJ.checkUnique("abcdef"));
    }

    @Test
    public void testCheckUnique_DuplicateChars() {
        assertTrue(MainJ.checkUnique("aabbcc"));
    }

    @Test
    public void testCheckUnique_EmptyString() {
        assertFalse(MainJ.checkUnique(""));
    }

    @Test
    public void testCheckUnique_SingleChar() {
        assertFalse(MainJ.checkUnique("a"));
    }

    @Test
    public void testCheckUnique_AllSameChars() {
        assertTrue(MainJ.checkUnique("aaa"));
    }

    @Test
    public void testSortStringToChar() {
        char[] result = MainJ.sortStringToChar("cba");
        assertArrayEquals(new char[]{'a', 'b', 'c'}, result);
    }

    @Test
    public void testSortStringToChar_Empty() {
        char[] result = MainJ.sortStringToChar("");
        assertArrayEquals(new char[0], result);
    }

    @Test
    public void testSortString() {
        String result = MainJ.sortString("cba");
        assertEquals("abc", result);
    }

    @Test
    public void testSortString_Empty() {
        String result = MainJ.sortString("");
        assertEquals("", result);
    }

    @Test
    public void testReplaceSpaces() {
        String result = MainJ.replaceSpaces("Mr John Smith", "%20");
        assertEquals("Mr%20John%20Smith%20", result); // Note: the method appends extra at end
    }

    @Test
    public void testReplaceSpaces_NoSpaces() {
        String result = MainJ.replaceSpaces("Hello", "%20");
        assertEquals("Hello%20", result);
    }

    @Test
    public void testReplaceSpaces_MultipleSpaces() {
        String result = MainJ.replaceSpaces("a  b", "%20");
        assertEquals("a%20b%20", result);
    }

    @Test
    public void testReplaceSpaces_Empty() {
        String result = MainJ.replaceSpaces("", "%20");
        assertEquals("%20", result);
    }
}
