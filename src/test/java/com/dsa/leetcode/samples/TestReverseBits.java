package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestReverseBits {

	@Test
	void returnsReversedBitsForPositiveNumber() {
		ReverseBits reverseBits = new ReverseBits();
		assertEquals(-1610612736, reverseBits.reverseBits(5)); // Corrected expected value
	}

	@Test
	void returnsReversedBitsForZero() {
		ReverseBits reverseBits = new ReverseBits();
		assertEquals(0, reverseBits.reverseBits(0));
	}

	@Test
	void returnsReversedBitsForNegativeNumber() {
		ReverseBits reverseBits = new ReverseBits();
		assertEquals(-536870913, reverseBits.reverseBits(-5)); // Corrected expected value
	}

	@Test
	void returnsReversedBitsForMaxInt() {
		ReverseBits reverseBits = new ReverseBits();
		assertEquals(-2, reverseBits.reverseBits(Integer.MAX_VALUE));
	}

	@Test
	void returnsReversedBitsForMinInt() {
		ReverseBits reverseBits = new ReverseBits();
		assertEquals(1, reverseBits.reverseBits(Integer.MIN_VALUE));
	}

}
