package com.rga.q.search;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Comprehensive test suite for BinarySearch class
 * Tests cover normal operations, edge cases, boundary conditions, and error scenarios
 */
@DisplayName("Binary Search Algorithm Test Suite")
public class BinarySearchTest {

    @Test
    @DisplayName("Test basic binary search - element found")
    public void testBinarySearchBasicFound() {
        List<Integer> arr = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        assertEquals(0, BinarySearch.binarySearch(arr, 1), "Should find first element at index 0");
        assertEquals(4, BinarySearch.binarySearch(arr, 5), "Should find middle element at index 4");
        assertEquals(9, BinarySearch.binarySearch(arr, 10), "Should find last element at index 9");
        assertEquals(2, BinarySearch.binarySearch(arr, 3), "Should find element at index 2");
    }

    @Test
    @DisplayName("Test binary search - element not found")
    public void testBinarySearchNotFound() {
        List<Integer> arr = List.of(1, 3, 5, 7, 9, 11, 13, 15);
        
        assertEquals(-1, BinarySearch.binarySearch(arr, 2), "Should return -1 for missing element");
        assertEquals(-1, BinarySearch.binarySearch(arr, 4), "Should return -1 for missing element");
        assertEquals(-1, BinarySearch.binarySearch(arr, 12), "Should return -1 for missing element");
        assertEquals(-1, BinarySearch.binarySearch(arr, 16), "Should return -1 for element greater than max");
        assertEquals(-1, BinarySearch.binarySearch(arr, 0), "Should return -1 for element less than min");
    }

    @Test
    @DisplayName("Test binary search with single element")
    public void testBinarySearchSingleElement() {
        List<Integer> arr = List.of(42);
        
        assertEquals(0, BinarySearch.binarySearch(arr, 42), "Should find single element at index 0");
        assertEquals(-1, BinarySearch.binarySearch(arr, 41), "Should return -1 for missing element in single-element array");
        assertEquals(-1, BinarySearch.binarySearch(arr, 43), "Should return -1 for missing element in single-element array");
    }

    @Test
    @DisplayName("Test binary search with two elements")
    public void testBinarySearchTwoElements() {
        List<Integer> arr = List.of(10, 20);
        
        assertEquals(0, BinarySearch.binarySearch(arr, 10), "Should find first element at index 0");
        assertEquals(1, BinarySearch.binarySearch(arr, 20), "Should find second element at index 1");
        assertEquals(-1, BinarySearch.binarySearch(arr, 15), "Should return -1 for missing middle element");
        assertEquals(-1, BinarySearch.binarySearch(arr, 5), "Should return -1 for element less than minimum");
        assertEquals(-1, BinarySearch.binarySearch(arr, 25), "Should return -1 for element greater than maximum");
    }

    @Test
    @DisplayName("Test binary search with null array")
    public void testBinarySearchNullArray() {
        assertEquals(-1, BinarySearch.binarySearch(null, 5), "Should return -1 for null array");
    }

    @Test
    @DisplayName("Test binary search with empty array")
    public void testBinarySearchEmptyArray() {
        List<Integer> emptyArr = new ArrayList<>();
        assertEquals(-1, BinarySearch.binarySearch(emptyArr, 5), "Should return -1 for empty array");
        
        // Test with Collections.emptyList()
        assertEquals(-1, BinarySearch.binarySearch(Collections.emptyList(), 10), "Should return -1 for empty list");
    }

    @Test
    @DisplayName("Test binary search with duplicate elements")
    public void testBinarySearchDuplicates() {
        List<Integer> arr = List.of(1, 2, 2, 2, 3, 4, 5);
        
        // Note: Binary search may return any valid index for duplicates
        int result = BinarySearch.binarySearch(arr, 2);
        assertTrue(result >= 1 && result <= 3, "Should find one of the duplicate elements (index 1, 2, or 3)");
        assertEquals(2, arr.get(result), "Should return correct value at found index");
        
        assertEquals(0, BinarySearch.binarySearch(arr, 1), "Should find unique element correctly");
        assertEquals(6, BinarySearch.binarySearch(arr, 5), "Should find last element correctly");
    }

    @Test
    @DisplayName("Test binary search with large array")
    public void testBinarySearchLargeArray() {
        // Create array from 0 to 999 (even numbers only)
        List<Integer> largeArr = new ArrayList<>();
        for (int i = 0; i < 1000; i += 2) {
            largeArr.add(i);
        }
        
        assertEquals(0, BinarySearch.binarySearch(largeArr, 0), "Should find first element in large array");
        assertEquals(499, BinarySearch.binarySearch(largeArr, 998), "Should find last element in large array");
        assertEquals(250, BinarySearch.binarySearch(largeArr, 500), "Should find middle element in large array");
        assertEquals(-1, BinarySearch.binarySearch(largeArr, 501), "Should return -1 for odd number in even-only array");
    }

    @Test
    @DisplayName("Test binary search boundary conditions")
    public void testBinarySearchBoundaryConditions() {
        List<Integer> arr = List.of(10, 20, 30, 40, 50);
        
        // Test elements just outside the range
        assertEquals(-1, BinarySearch.binarySearch(arr, 9), "Should return -1 for element just below minimum");
        assertEquals(-1, BinarySearch.binarySearch(arr, 51), "Should return -1 for element just above maximum");
        
        // Test boundary elements
        assertEquals(0, BinarySearch.binarySearch(arr, 10), "Should find minimum element");
        assertEquals(4, BinarySearch.binarySearch(arr, 50), "Should find maximum element");
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, -1, 0, 1, 42, 100, 1000})
    @DisplayName("Test binary search with various target values")
    public void testBinarySearchParameterized(int target) {
        List<Integer> arr = List.of(-50, -10, 0, 10, 20, 42, 100, 500, 1000);
        
        int result = BinarySearch.binarySearch(arr, target);
        
        if (result != -1) {
            assertEquals(target, arr.get(result), "Found element should match target value");
            assertTrue(result >= 0 && result < arr.size(), "Index should be within valid range");
        } else {
            // Verify target is indeed not in the array
            assertFalse(arr.contains(target), "Target should not exist in array when result is -1");
        }
    }

    @Test
    @DisplayName("Test binary search with negative numbers")
    public void testBinarySearchNegativeNumbers() {
        List<Integer> arr = List.of(-100, -50, -25, -10, -5, -1);
        
        assertEquals(0, BinarySearch.binarySearch(arr, -100), "Should find first negative element");
        assertEquals(5, BinarySearch.binarySearch(arr, -1), "Should find last negative element");
        assertEquals(2, BinarySearch.binarySearch(arr, -25), "Should find middle negative element");
        assertEquals(-1, BinarySearch.binarySearch(arr, -75), "Should return -1 for missing negative element");
        assertEquals(-1, BinarySearch.binarySearch(arr, 0), "Should return -1 for positive number in negative array");
    }

    @Test
    @DisplayName("Test binary search with mixed positive and negative numbers")
    public void testBinarySearchMixedNumbers() {
        List<Integer> arr = List.of(-10, -5, 0, 5, 10, 15, 20);
        
        assertEquals(0, BinarySearch.binarySearch(arr, -10), "Should find negative number");
        assertEquals(2, BinarySearch.binarySearch(arr, 0), "Should find zero");
        assertEquals(6, BinarySearch.binarySearch(arr, 20), "Should find positive number");
        assertEquals(-1, BinarySearch.binarySearch(arr, 3), "Should return -1 for missing number in range");
    }

    @Test
    @DisplayName("Test binary search algorithm correctness")
    public void testBinarySearchAlgorithmCorrectness() {
        List<Integer> arr = List.of(1, 3, 5, 7, 9, 11, 13, 15, 17, 19);
        
        // Test that all existing elements can be found
        for (int i = 0; i < arr.size(); i++) {
            assertEquals(i, BinarySearch.binarySearch(arr, arr.get(i)), 
                "Element " + arr.get(i) + " should be found at index " + i);
        }
        
        // Test that non-existing elements return -1
        int[] nonExisting = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        for (int target : nonExisting) {
            assertEquals(-1, BinarySearch.binarySearch(arr, target), 
                "Non-existing element " + target + " should return -1");
        }
    }
}
