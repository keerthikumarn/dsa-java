package com.dsa.leetcode.samples;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestCountApplesAndOranges {

	private CountApplesAndOranges counter;

	@BeforeEach
	void setUp() throws Exception {
		counter = new CountApplesAndOranges();
	}

	@Test
	@DisplayName("Should count apples and oranges within the range")
	void countApplesAndOrangesWithinRange() {
		counter.countApplesAndOranges(7, 10, 4, 12, Arrays.asList(2, 3, -4), Arrays.asList(3, -2, -4));
		// Expected output: 1 apple, 2 oranges
	}

	@Test
	@DisplayName("Should count zero apples and oranges when none fall within the range")
	void countZeroApplesAndOrangesWhenNoneInRange() {
		counter.countApplesAndOranges(7, 10, 4, 12, Arrays.asList(-2, -3, -4), Arrays.asList(5, 6, 7));
		// Expected output: 0 apples, 0 oranges
	}

	@Test
	@DisplayName("Should handle empty lists of apples and oranges")
	void handleEmptyListsOfApplesAndOranges() {
		counter.countApplesAndOranges(7, 10, 4, 12, Collections.emptyList(), Collections.emptyList());
		// Expected output: 0 apples, 0 oranges
	}

	@Test
	@DisplayName("Should handle single apple and orange falling within the range")
	void handleSingleAppleAndOrangeWithinRange() {
		counter.countApplesAndOranges(7, 10, 4, 12, Collections.singletonList(3), Collections.singletonList(-2));
		// Expected output: 1 apple, 1 orange
	}

	@Test
	@DisplayName("Should handle apples and oranges landing exactly on the boundaries")
	void handleApplesAndOrangesOnBoundaries() {
		counter.countApplesAndOranges(7, 10, 4, 12, Arrays.asList(3, 6), Arrays.asList(-5, -2));
	}
}
