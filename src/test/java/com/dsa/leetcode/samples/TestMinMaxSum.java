package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMinMaxSum {

	private MinMaxSum minMaxSum;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@BeforeEach
	void setUp() throws Exception {
		minMaxSum = new MinMaxSum();
		System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test
	public void testPrintOutput() {
		List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
		minMaxSum.miniMaxSum(arr);
		assertEquals("10 14\n", outContent.toString());
	}

}
