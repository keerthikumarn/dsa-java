package com.dsa.leetcode.samples;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestPalindromePartitioning {

	private PalindromePartitioning solution;

	@BeforeEach
	void setUp() {
		solution = new PalindromePartitioning();
	}

	@Test
	public void testPartition_aab() {
		List<List<String>> result = solution.partition("aab");
		assertEquals(2, result.size());
		assertEquals(2, result.size());
		assertTrue(result.contains(List.of("a", "a", "b")));
		assertTrue(result.contains(List.of("aa", "b")));
	}

	@Test
	public void testPartition_singleChar() {
		PalindromePartitioning pp = new PalindromePartitioning();
		List<List<String>> result = pp.partition("z");
		assertEquals(1, result.size());
		assertEquals(List.of(List.of("z")), result);
	}

	@Test
	public void testPartition_emptyString() {
		PalindromePartitioning pp = new PalindromePartitioning();
		List<List<String>> result = pp.partition("");
		assertEquals(1, result.size());
		assertEquals(List.of(List.of()), result);
	}

}
