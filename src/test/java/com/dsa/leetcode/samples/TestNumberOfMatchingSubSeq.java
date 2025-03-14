package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNumberOfMatchingSubSeq {

	private NumberOfMatchingSubSeq counter;

	@BeforeEach
	public void setUp() {
		counter = new NumberOfMatchingSubSeq();
	}

	@Test
	public void testBasicCases() {
		assertEquals(3, counter.numMatchingSubseq("abcde", new String[] { "a", "bb", "acd", "ace" }));
		assertEquals(2, counter.numMatchingSubseq("abcd", new String[] { "ab", "cd", "e" }));
		assertEquals(0, counter.numMatchingSubseq("xyz", new String[] { "a", "b", "c" }));
		assertEquals(3, counter.numMatchingSubseq("hello", new String[] { "h", "lo", "hello" }));
	}

	@Test
	public void testEdgeCases() {
		assertEquals(0, counter.numMatchingSubseq("", new String[] { "a", "abc" })); // Empty s
		assertEquals(0, counter.numMatchingSubseq("abc", new String[] {})); // Empty words list
		assertEquals(3, counter.numMatchingSubseq("aaa", new String[] { "a", "aa", "aaa" })); // Repeated characters
	}

	@Test
	public void testLongInputs() {
		String s = "abcdefghijabcdefghijabcdefghijabcdefghij"; // Repeated pattern
		String[] words = { "abc", "hij", "def", "ghj", "ijk", "zzz", "aabb", "jih" };
		assertEquals(6, counter.numMatchingSubseq(s, words)); // Only valid subsequences counted
	}

	@Test
	public void testNonMatchingCases() {
		assertEquals(0, counter.numMatchingSubseq("abcde", new String[] { "f", "gh", "ijk" }));
		assertEquals(0, counter.numMatchingSubseq("xyz", new String[] { "abc", "pq", "rst" }));
		assertEquals(0, counter.numMatchingSubseq("abc", new String[] { "acb", "bac", "cba" })); // Wrong order
	}

	@Test
	public void testDuplicateWords() {
		assertEquals(4, counter.numMatchingSubseq("abcdefg", new String[] { "abc", "abc", "fg", "fg" }));
	}

}
