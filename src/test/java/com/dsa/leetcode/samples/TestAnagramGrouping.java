package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class TestAnagramGrouping {

	private final AnagramGrouping anagramGrouping = new AnagramGrouping();

	@Test
	public void testGroupAnagramsWithValidInput() {
		String[] input = { "act", "pots", "tops", "cat", "stop", "hat" };
		List<List<String>> expected = Arrays.asList(Arrays.asList("act", "cat"), Arrays.asList("pots", "tops", "stop"),
				Arrays.asList("hat"));
		List<List<String>> result = anagramGrouping.groupAnagrams(input);
		assertAnagramGroupsEqual(expected, result);
	}

	@Test
	public void testGroupAnagramsWithEmptyInput() {
		String[] input = {};
		List<List<String>> expected = new ArrayList<>();
		List<List<String>> result = anagramGrouping.groupAnagrams(input);
		assertEquals(expected, result);
	}

	@Test
	public void testGroupAnagramsWithSingleElement() {
		String[] input = { "abc" };
		List<List<String>> expected = Collections.singletonList(Collections.singletonList("abc"));
		List<List<String>> result = anagramGrouping.groupAnagrams(input);
		assertEquals(expected, result);
	}

	@Test
	public void testGroupAnagramsWithIdenticalElements() {
		String[] input = { "abc", "abc", "abc" };
		List<List<String>> expected = Collections.singletonList(Arrays.asList("abc", "abc", "abc"));
		List<List<String>> result = anagramGrouping.groupAnagrams(input);
		assertEquals(expected, result);
	}

	@Test
	public void testGroupAnagramsWithNullInput() {
		String[] input = null;
		List<List<String>> expected = new ArrayList<>();
		List<List<String>> result = anagramGrouping.groupAnagrams(input);
		assertEquals(expected, result);
	}

	private void assertAnagramGroupsEqual(List<List<String>> expected, List<List<String>> actual) {
		Set<Set<String>> expectedSet = new HashSet<>();
		for (List<String> group : expected) {
			expectedSet.add(new HashSet<>(group));
		}
		Set<Set<String>> actualSet = new HashSet<>();
		for (List<String> group : actual) {
			actualSet.add(new HashSet<>(group));
		}
		assertEquals(expectedSet, actualSet);
	}
}
