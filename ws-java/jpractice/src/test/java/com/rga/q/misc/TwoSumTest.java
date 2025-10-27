package com.rga.q.misc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

/**
 * Test class for TwoSum implementation
 * Tests various scenarios including edge cases
 */
public class TwoSumTest {

    @Test
    @DisplayName("Test with valid input - target found at beginning")
    void testValidInputTargetAtBeginning() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        Map<String, Integer> result = TwoSum.findTarget(nums, target);
        
        assertNotNull(result);
        assertEquals(0, result.get("index1"));
        assertEquals(1, result.get("index2"));
        assertEquals(target, nums[result.get("index1")] + nums[result.get("index2")]);
    }

    @Test
    @DisplayName("Test with valid input - target found at end")
    void testValidInputTargetAtEnd() {
        int[] nums = {3, 2, 4};
        int target = 6;
        
        Map<String, Integer> result = TwoSum.findTarget(nums, target);
        
        assertNotNull(result);
        assertEquals(1, result.get("index1"));
        assertEquals(2, result.get("index2"));
        assertEquals(target, nums[result.get("index1")] + nums[result.get("index2")]);
    }

    @Test
    @DisplayName("Test with same numbers")
    void testSameNumbers() {
        int[] nums = {3, 3};
        int target = 6;
        
        Map<String, Integer> result = TwoSum.findTarget(nums, target);
        
        assertNotNull(result);
        assertEquals(0, result.get("index1"));
        assertEquals(1, result.get("index2"));
        assertEquals(target, nums[result.get("index1")] + nums[result.get("index2")]);
    }

    @Test
    @DisplayName("Test with negative numbers")
    void testNegativeNumbers() {
        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;
        
        Map<String, Integer> result = TwoSum.findTarget(nums, target);
        
        assertNotNull(result);
        assertTrue(result.containsKey("index1"));
        assertTrue(result.containsKey("index2"));
        assertEquals(target, nums[result.get("index1")] + nums[result.get("index2")]);
    }

    @Test
    @DisplayName("Test with mixed positive and negative numbers")
    void testMixedNumbers() {
        int[] nums = {-3, 4, 3, 90};
        int target = 0;
        
        Map<String, Integer> result = TwoSum.findTarget(nums, target);
        
        assertNotNull(result);
        assertEquals(0, result.get("index1"));
        assertEquals(2, result.get("index2"));
        assertEquals(target, nums[result.get("index1")] + nums[result.get("index2")]);
    }

    @Test
    @DisplayName("Test with zero target")
    void testZeroTarget() {
        int[] nums = {0, 4, 3, 0};
        int target = 0;
        
        Map<String, Integer> result = TwoSum.findTarget(nums, target);
        
        assertNotNull(result);
        assertEquals(0, result.get("index1"));
        assertEquals(3, result.get("index2"));
        assertEquals(target, nums[result.get("index1")] + nums[result.get("index2")]);
    }

    @Test
    @DisplayName("Test with large numbers")
    void testLargeNumbers() {
        int[] nums = {1000000, 2000000, 3000000, 4000000};
        int target = 5000000;
        
        Map<String, Integer> result = TwoSum.findTarget(nums, target);
        
        assertNotNull(result);
        assertEquals(1, result.get("index1"));
        assertEquals(2, result.get("index2"));
        assertEquals(target, nums[result.get("index1")] + nums[result.get("index2")]);
    }

    @Test
    @DisplayName("Test when no solution exists")
    void testNoSolution() {
        int[] nums = {1, 2, 3, 4};
        int target = 10;
        
        Map<String, Integer> result = TwoSum.findTarget(nums, target);
        
        assertNotNull(result);
        assertNull(result.get("index1"));
        assertNull(result.get("index2"));
    }

    @Test
    @DisplayName("Test with minimum array size")
    void testMinimumArraySize() {
        int[] nums = {5, 5};
        int target = 10;
        
        Map<String, Integer> result = TwoSum.findTarget(nums, target);
        
        assertNotNull(result);
        assertEquals(0, result.get("index1"));
        assertEquals(1, result.get("index2"));
        assertEquals(target, nums[result.get("index1")] + nums[result.get("index2")]);
    }

    @Test
    @DisplayName("Test original example from main method")
    void testOriginalExample() {
        int[] nums = {2, 1, 5, 3};
        int target = 7;
        
        Map<String, Integer> result = TwoSum.findTarget(nums, target);
        
        assertNotNull(result);
        assertEquals(0, result.get("index1"));
        assertEquals(2, result.get("index2"));
        assertEquals(target, nums[result.get("index1")] + nums[result.get("index2")]);
    }

    @Test
    @DisplayName("Test with duplicate numbers and multiple valid solutions")
    void testDuplicateNumbersMultipleSolutions() {
        int[] nums = {3, 3, 11, 15};
        int target = 6;
        
        Map<String, Integer> result = TwoSum.findTarget(nums, target);
        
        assertNotNull(result);
        assertEquals(0, result.get("index1"));
        assertEquals(1, result.get("index2"));
        assertEquals(target, nums[result.get("index1")] + nums[result.get("index2")]);
    }

    @Test
    @DisplayName("Test performance with larger array")
    void testPerformanceWithLargerArray() {
        int[] nums = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums[i] = i;
        }
        nums[500] = 250; // This will make nums[250] + nums[500] = 500
        int target = 500;
        
        long startTime = System.nanoTime();
        Map<String, Integer> result = TwoSum.findTarget(nums, target);
        long endTime = System.nanoTime();
        
        assertNotNull(result);
        assertTrue(result.containsKey("index1"));
        assertTrue(result.containsKey("index2"));
        assertEquals(target, nums[result.get("index1")] + nums[result.get("index2")]);
        
        // Should complete in reasonable time (less than 1ms for this size)
        assertTrue((endTime - startTime) < 1_000_000, "Algorithm should be efficient");
    }
}
