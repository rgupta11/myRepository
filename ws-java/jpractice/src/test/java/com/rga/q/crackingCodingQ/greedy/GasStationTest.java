package com.rga.q.crackingCodingQ.greedy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("GasStation Algorithm Test Suite")
public class GasStationTest {

    @Test
    @DisplayName("Example case returns starting station 3")
    public void testExampleCase() {
        int[] gas = {5, 2, 0, 3, 3};
        int[] cost = {1, 5, 5, 1, 1};

        assertEquals(3, GasStation.canCompleteCircuit(gas, cost));
    }

    @Test
    @DisplayName("Return -1 when total gas is less than total cost")
    public void testImpossibleCircuit() {
        int[] gas = {1, 2, 3};
        int[] cost = {3, 3, 3};

        assertEquals(-1, GasStation.canCompleteCircuit(gas, cost));
    }

    @Test
    @DisplayName("Single station succeeds when gas equals cost")
    public void testSingleStationSuccess() {
        int[] gas = {5};
        int[] cost = {5};

        assertEquals(0, GasStation.canCompleteCircuit(gas, cost));
    }

    @Test
    @DisplayName("Single station fails when gas is insufficient")
    public void testSingleStationFailure() {
        int[] gas = {4};
        int[] cost = {5};

        assertEquals(-1, GasStation.canCompleteCircuit(gas, cost));
    }

    @Test
    @DisplayName("Unique valid start in a larger circuit")
    public void testUniqueStartIndex() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        assertEquals(3, GasStation.canCompleteCircuit(gas, cost));
    }

    @Test
    @DisplayName("Empty circuit returns 0")
    public void testEmptyCircuit() {
        int[] gas = {};
        int[] cost = {};

        assertEquals(0, GasStation.canCompleteCircuit(gas, cost));
    }

    @Test
    @DisplayName("All stations have zero cost and zero gas")
    public void testZeroGasZeroCost() {
        int[] gas = {0, 0, 0};
        int[] cost = {0, 0, 0};

        assertEquals(0, GasStation.canCompleteCircuit(gas, cost));
    }
}
