package com.rga.q.twoPointer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TripletTriangleTest {

    @Test
    public void testExampleInput() {
        int[] nums = {11, 4, 9, 6, 15, 18};
        int result = TripletTriangle.findTriplet(nums);
        assertEquals(10, result);
    }

    @Test
    public void testNoTriplets() {
        int[] nums = {1, 2, 3};
        int result = TripletTriangle.findTriplet(nums);
        assertEquals(0, result);
    }

    @Test
    public void testAllSidesEqual() {
        int[] nums = {5, 5, 5};
        int result = TripletTriangle.findTriplet(nums);
        assertEquals(1, result);
    }

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        int result = TripletTriangle.findTriplet(nums);
        assertEquals(0, result);
    }

    @Test
    public void testTwoElements() {
        int[] nums = {7, 10};
        int result = TripletTriangle.findTriplet(nums);
        assertEquals(0, result);
    }

    @Test
    public void testLargeNumbers() {
        int[] nums = {100, 101, 102, 103};
        int result = TripletTriangle.findTriplet(nums);
        assertEquals(4, result);
    }

    @Test
    public void testDuplicates() {
        int[] nums = {2, 2, 3, 4};
        int result = TripletTriangle.findTriplet(nums);
        assertEquals(3, result);
    }
}