package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestHammingWeight {
	
	private HammingWeight weight;
	
	@BeforeEach
	void setUp() throws Exception {
		weight = new HammingWeight();
	}

	@Test
	void testHammingWeightOfZero() {
		assertEquals(0, weight.hammingWeight(0));
	}
	
	@Test
	void testHammingWeightOfOne() {
		assertEquals(1, weight.hammingWeight(1));
	}
	
	@Test
	void testHammingWeightOfAllOnes() {
		assertEquals(0, weight.hammingWeight(-1));
	}

}
