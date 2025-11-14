package com.rga.q.search;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class BinSearchTrueFalseTest {

    @Test
    public void testFindBoundary_TargetTrue() {
        List<Boolean> arr = List.of(false, false, true, true, true);
        int result = BinSearchTrueFalse.findBoundary(arr, true);
        assertEquals(2, result);
    }

    @Test
    public void testFindBoundary_TargetFalse() {
        List<Boolean> arr = List.of(false, false, true, true, true);
        int result = BinSearchTrueFalse.findBoundary(arr, false);
        assertEquals(0, result);
    }

    @Test
    public void testFindBoundary_AllTrue() {
        List<Boolean> arr = List.of(true, true, true);
        int result = BinSearchTrueFalse.findBoundary(arr, true);
        assertEquals(0, result);
    }

    @Test
    public void testFindBoundary_AllFalse() {
        List<Boolean> arr = List.of(false, false, false);
        int result = BinSearchTrueFalse.findBoundary(arr, false);
        assertEquals(0, result);
    }

    @Test
    public void testFindBoundary_TargetNotPresent() {
        List<Boolean> arr = List.of(false, false, false);
        int result = BinSearchTrueFalse.findBoundary(arr, true);
        assertEquals(-1, result);
    }

    @Test
    public void testFindBoundary_EmptyList() {
        List<Boolean> arr = List.of();
        int result = BinSearchTrueFalse.findBoundary(arr, true);
        assertEquals(-1, result);
    }

    @Test
    public void testFindBoundary_NullList() {
        int result = BinSearchTrueFalse.findBoundary(null, true);
        assertEquals(-1, result);
    }

}