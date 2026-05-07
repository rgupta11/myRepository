package com.rga.q.crackingCodingQ.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ClimbingStairs DP Test Suite")
public class ClimbingStairsTest {

    @Test
    @DisplayName("Test for 0 stairs")
    public void testZeroStairs() {
        assertEquals(1, ClimbingStairs.stairsTabulation(0));
    }

    @Test
    @DisplayName("Test for 1 stair")
    public void testOneStair() {
        assertEquals(1, ClimbingStairs.stairsTabulation(1));
    }

    @Test
    @DisplayName("Test for 2 stairs")
    public void testTwoStairs() {
        assertEquals(2, ClimbingStairs.stairsTabulation(2));
    }

    @Test
    @DisplayName("Test for 3 stairs")
    public void testThreeStairs() {
        assertEquals(3, ClimbingStairs.stairsTabulation(3));
    }

    @Test
    @DisplayName("Test for 4 stairs")
    public void testFourStairs() {
        assertEquals(5, ClimbingStairs.stairsTabulation(4));
    }

    @Test
    @DisplayName("Test for 5 stairs")
    public void testFiveStairs() {
        assertEquals(8, ClimbingStairs.stairsTabulation(5));
    }

    @Test
    @DisplayName("Test for 10 stairs")
    public void testTenStairs() {
        assertEquals(89, ClimbingStairs.stairsTabulation(10));
    }
}