package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBeautifulBinaryString {

	private BeautifulBinaryString beautifulBinaryString;

	@BeforeEach
	void setUp() throws Exception {
		beautifulBinaryString = new BeautifulBinaryString();
	}

	@Test
	void returnsZeroWhenNoOccurrencesOf010() {
		int result = beautifulBinaryString.minSteps(5, "11111");
		assertEquals(0, result);
	}

	@Test
	void returnsCorrectStepsForSingleOccurrenceOf010() {
		int result = beautifulBinaryString.minSteps(3, "010");
		assertEquals(1, result);
	}

	@Test
	void returnsCorrectStepsForMultipleNonOverlappingOccurrencesOf010() {
		int result = beautifulBinaryString.minSteps(9, "010101010");
		assertEquals(2, result);
	}

	@Test
	void returnsCorrectStepsForOverlappingOccurrencesOf010() {
		int result = beautifulBinaryString.minSteps(6, "010010");
		assertEquals(2, result);
	}

	@Test
	void handlesEmptyString() {
		int result = beautifulBinaryString.minSteps(0, "");
		assertEquals(0, result);
	}

	@Test
	void handlesStringWithoutAnyZeroes() {
		int result = beautifulBinaryString.minSteps(5, "11111");
		assertEquals(0, result);
	}

	@Test
	void handlesStringWithoutAnyOnes() {
		int result = beautifulBinaryString.minSteps(5, "00000");
		assertEquals(0, result);
	}

	@Test
	void handlesStringWithMixedCharactersButNo010() {
		int result = beautifulBinaryString.minSteps(6, "101101");
		assertEquals(0, result);
	}

}
