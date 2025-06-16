package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestPermutations {

	private Permutations permutations;

	@BeforeEach
	void setUp() {
		permutations = new Permutations();
	}

	@Test
	public void testPermuteThreeElements() {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> result = permutations.permute(nums);

		// Expected number of permutations = 3! = 6
		assertEquals(6, result.size(), "There should be 6 permutations for 3 elements.");

		// Expected permutations
		Set<List<Integer>> expected = new HashSet<>();
		expected.add(Arrays.asList(1, 2, 3));
		expected.add(Arrays.asList(1, 3, 2));
		expected.add(Arrays.asList(2, 1, 3));
		expected.add(Arrays.asList(2, 3, 1));
		expected.add(Arrays.asList(3, 1, 2));
		expected.add(Arrays.asList(3, 2, 1));
		// Check that all results are in expected and unique
		Set<List<Integer>> actual = new HashSet<>(result);
		assertEquals(expected, actual, "Permutations should match expected set.");
	}

	@Test
	public void testPermuteSingleElement() {
		int[] nums = { 42 };
		List<List<Integer>> result = permutations.permute(nums);
		assertEquals(1, result.size());
		assertEquals(Collections.singletonList(Arrays.asList(42)), result);
	}

	@Test
	public void testPermuteEmptyArray() {
		int[] nums = {};
		List<List<Integer>> result = permutations.permute(nums);
		assertEquals(1, result.size(), "An empty array has one permutation: the empty list.");
		assertEquals(Collections.singletonList(new ArrayList<>()), result);
	}
}
