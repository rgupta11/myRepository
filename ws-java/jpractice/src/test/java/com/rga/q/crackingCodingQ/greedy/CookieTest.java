package com.rga.q.crackingCodingQ.greedy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CookieTest {

    @Test
    public void testExampleFromMain() {
        int[] cookies = {1, 2, 3};
        int[] greed = {1, 1};
        assertEquals(2, Cookie.cookieGreed(cookies, greed));
    }

    @Test
    public void testEmptyCookies() {
        int[] cookies = {};
        int[] greed = {1, 2};
        assertEquals(0, Cookie.cookieGreed(cookies, greed));
    }

    @Test
    public void testEmptyGreed() {
        int[] cookies = {1, 2};
        int[] greed = {};
        assertEquals(0, Cookie.cookieGreed(cookies, greed));
    }

    @Test
    public void testBothEmpty() {
        int[] cookies = {};
        int[] greed = {};
        assertEquals(0, Cookie.cookieGreed(cookies, greed));
    }

    @Test
    public void testNoCookiesSatisfy() {
        int[] cookies = {1, 2};
        int[] greed = {3, 4};
        assertEquals(0, Cookie.cookieGreed(cookies, greed));
    }

    @Test
    public void testAllCookiesSatisfy() {
        int[] cookies = {3, 4};
        int[] greed = {1, 2};
        assertEquals(2, Cookie.cookieGreed(cookies, greed));
    }

    @Test
    public void testPartialSatisfaction() {
        int[] cookies = {1, 2, 3};
        int[] greed = {1, 2, 4};
        assertEquals(2, Cookie.cookieGreed(cookies, greed));
    }

    @Test
    public void testSingleCookieSingleGreedSatisfy() {
        int[] cookies = {2};
        int[] greed = {1};
        assertEquals(1, Cookie.cookieGreed(cookies, greed));
    }

    @Test
    public void testSingleCookieSingleGreedNotSatisfy() {
        int[] cookies = {1};
        int[] greed = {2};
        assertEquals(0, Cookie.cookieGreed(cookies, greed));
    }

    @Test
    public void testDuplicates() {
        int[] cookies = {1, 1, 2};
        int[] greed = {1, 1, 1};
        assertEquals(3, Cookie.cookieGreed(cookies, greed));
    }

    @Test
    public void testMoreGreedThanCookies() {
        int[] cookies = {1, 2};
        int[] greed = {1, 2, 3};
        assertEquals(2, Cookie.cookieGreed(cookies, greed));
    }
}