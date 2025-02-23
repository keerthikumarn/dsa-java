package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestThreeSum {

	private ThreeSum obj;

	@BeforeEach
	void setUp() throws Exception {
		obj = new ThreeSum();
	}

	@Test
	void testThreeSum() {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		assertEquals(2, obj.threeSum(nums).size());
	}

	@Test
	void testThreeSumHashMapApproach() {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		assertEquals(2, obj.threeSumHashMapApproach(nums).size());
	}
}
