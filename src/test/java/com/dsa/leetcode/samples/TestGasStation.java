package com.dsa.leetcode.samples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestGasStation {

	private GasStation gasStation = null;
	
	@BeforeEach
	void setUp() {
		gasStation = new GasStation();
	}
	

    @Test
    public void testExample1() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        assertEquals(3, gasStation.canCompleteCircuit(gas, cost));
    }

    @Test
    public void testExample2() {
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        assertEquals(-1, gasStation.canCompleteCircuit(gas, cost));
    }

    @Test
    public void testSingleStationSuccess() {
        int[] gas = {5};
        int[] cost = {4};
        assertEquals(0, gasStation.canCompleteCircuit(gas, cost));
    }

    @Test
    public void testSingleStationFail() {
        int[] gas = {2};
        int[] cost = {3};
        assertEquals(-1, gasStation.canCompleteCircuit(gas, cost));
    }

    @Test
    public void testAllStationsEqual() {
        int[] gas = {5, 5, 5, 5};
        int[] cost = {5, 5, 5, 5};
        assertEquals(0, gasStation.canCompleteCircuit(gas, cost));
    }

    @Test
    public void testStartIndexAfterWrapAround() {
        int[] gas = {4, 5, 2, 6, 5};
        int[] cost = {3, 2, 7, 3, 2};
        assertEquals(3, gasStation.canCompleteCircuit(gas, cost));
    }

    @Test
    public void testEmptyInput() {
        int[] gas = {};
        int[] cost = {};
        assertEquals(0, gasStation.canCompleteCircuit(gas, cost));
    }

}
