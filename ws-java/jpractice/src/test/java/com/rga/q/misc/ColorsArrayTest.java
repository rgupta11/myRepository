package com.rga.q.misc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for ColorsArray
 * Tests the sortColors method (Dutch National Flag algorithm) with various input scenarios
 * Colors: 0 = Red, 1 = White, 2 = Blue
 */
public class ColorsArrayTest {

    @Test
    @DisplayName("Test basic color sorting")
    public void testBasicColorSorting() {
        int[] input = {2, 0, 2, 1, 1, 0};
        int[] expected = {0, 0, 1, 1, 2, 2};
        int[] result = ColorsArray.sortColors(input);
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test already sorted array")
    public void testAlreadySortedArray() {
        int[] input = {0, 0, 1, 1, 2, 2};
        int[] expected = {0, 0, 1, 1, 2, 2};
        int[] result = ColorsArray.sortColors(input);
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test reverse sorted array")
    public void testReverseSortedArray() {
        int[] input = {2, 2, 1, 1, 0, 0};
        int[] expected = {0, 0, 1, 1, 2, 2};
        int[] result = ColorsArray.sortColors(input);
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test single color - all zeros")
    public void testAllZeros() {
        int[] input = {0, 0, 0, 0};
        int[] expected = {0, 0, 0, 0};
        int[] result = ColorsArray.sortColors(input);
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test single color - all ones")
    public void testAllOnes() {
        int[] input = {1, 1, 1, 1};
        int[] expected = {1, 1, 1, 1};
        int[] result = ColorsArray.sortColors(input);
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test single color - all twos")
    public void testAllTwos() {
        int[] input = {2, 2, 2, 2};
        int[] expected = {2, 2, 2, 2};
        int[] result = ColorsArray.sortColors(input);
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test single element array")
    public void testSingleElement() {
        int[] input0 = {0};
        int[] expected0 = {0};
        assertArrayEquals(expected0, ColorsArray.sortColors(input0));

        int[] input1 = {1};
        int[] expected1 = {1};
        assertArrayEquals(expected1, ColorsArray.sortColors(input1));

        int[] input2 = {2};
        int[] expected2 = {2};
        assertArrayEquals(expected2, ColorsArray.sortColors(input2));
    }

    @Test
    @DisplayName("Test empty array")
    public void testEmptyArray() {
        int[] input = {};
        int[] expected = {};
        int[] result = ColorsArray.sortColors(input);
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test two elements")
    public void testTwoElements() {
        int[] input1 = {2, 0};
        int[] expected1 = {0, 2};
        assertArrayEquals(expected1, ColorsArray.sortColors(input1));

        int[] input2 = {1, 0};
        int[] expected2 = {0, 1};
        assertArrayEquals(expected2, ColorsArray.sortColors(input2));

        int[] input3 = {2, 1};
        int[] expected3 = {1, 2};
        assertArrayEquals(expected3, ColorsArray.sortColors(input3));
    }

    @Test
    @DisplayName("Test complex array with all colors")
    public void testComplexArray() {
        int[] input = {2, 0, 2, 1, 1, 0, 2, 0, 1, 2, 1, 0};
        int[] expected = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2};
        int[] result = ColorsArray.sortColors(input);
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test array with invalid colors (non-standard values)")
    public void testArrayWithInvalidColors() {
        // Based on the implementation, invalid colors (not 0, 1, 2) are moved to the end
        int[] input = {2, 0, 3, 1, 5, 0, 2};
        int[] result = ColorsArray.sortColors(input);
        
        // Verify that valid colors (0, 1, 2) are sorted at the beginning
        // and invalid colors remain in some position
        // Check that all 0s come first, then 1s, then 2s
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        for (int color : input) {
            if (color == 0) zeroCount++;
            else if (color == 1) oneCount++;
            else if (color == 2) twoCount++;
        }
        
        // Verify the first zeroCount elements are 0s
        for (int i = 0; i < zeroCount; i++) {
            assertEquals(0, result[i], "All zeros should come first");
        }
        
        // Verify the next oneCount elements are 1s
        for (int i = zeroCount; i < zeroCount + oneCount; i++) {
            assertEquals(1, result[i], "All ones should come after zeros");
        }
        
        // Verify the next twoCount elements are 2s
        for (int i = zeroCount + oneCount; i < zeroCount + oneCount + twoCount; i++) {
            assertEquals(2, result[i], "All twos should come after ones");
        }
    }

    @Test
    @DisplayName("Test large array performance")
    public void testLargeArray() {
        int[] input = new int[1000];
        int[] expected = new int[1000];
        
        // Fill with random colors and create expected sorted array
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        for (int i = 0; i < 1000; i++) {
            input[i] = i % 3; // This creates pattern 0,1,2,0,1,2...
            if (input[i] == 0) zeroCount++;
            else if (input[i] == 1) oneCount++;
            else if (input[i] == 2) twoCount++;
        }
        
        // Create expected array
        int index = 0;
        for (int i = 0; i < zeroCount; i++) expected[index++] = 0;
        for (int i = 0; i < oneCount; i++) expected[index++] = 1;
        for (int i = 0; i < twoCount; i++) expected[index++] = 2;
        
        int[] result = ColorsArray.sortColors(input);
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Test that original array is modified in-place")
    public void testInPlaceModification() {
        int[] input = {2, 0, 1};
        int[] result = ColorsArray.sortColors(input);
        
        // The method should return the same array reference (modified in-place)
        assertSame(input, result, "Method should modify array in-place");
        
        // Verify the array is actually sorted
        int[] expected = {0, 1, 2};
        assertArrayEquals(expected, result);
        
        // Verify the original array was modified
        assertArrayEquals(expected, input);
    }

    @Test
    @DisplayName("Test Dutch National Flag problem example")
    public void testDutchNationalFlag() {
        // Classic example from the Dutch National Flag problem
        int[] input = {2, 0, 2, 1, 1, 0, 6, 0, 2, 2, 1, 1, 0, 3, 5};
        int[] result = ColorsArray.sortColors(input);
        
        // Count valid colors in input
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        for (int color : input) {
            if (color == 0) zeroCount++;
            else if (color == 1) oneCount++;
            else if (color == 2) twoCount++;
        }
        
        // Verify sorting of valid colors
        for (int i = 0; i < zeroCount; i++) {
            assertEquals(0, result[i]);
        }
        for (int i = zeroCount; i < zeroCount + oneCount; i++) {
            assertEquals(1, result[i]);
        }
        for (int i = zeroCount + oneCount; i < zeroCount + oneCount + twoCount; i++) {
            assertEquals(2, result[i]);
        }
    }
}
