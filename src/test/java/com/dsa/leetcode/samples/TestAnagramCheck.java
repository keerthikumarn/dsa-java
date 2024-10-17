package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class TestAnagramCheck {

	private final AnagramCheck anagramCheck = new AnagramCheck();

	@Test
	public void testAnagrams() {
		assertTrue(anagramCheck.isAnagram("listen", "silent"), "Expected 'listen' and 'silent' to be anagrams.");
		assertTrue(anagramCheck.isAnagram("evil", "vile"), "Expected 'evil' and 'vile' to be anagrams.");
		assertTrue(anagramCheck.isAnagram("triangle", "integral"),
				"Expected 'triangle' and 'integral' to be anagrams.");
		assertTrue(anagramCheck.isAnagram("carrace", "racecar"), "Expected 'racecar' and 'integral' to be anagrams.");
	}

	@Test
	public void testNonAnagrams() {
		assertFalse(anagramCheck.isAnagram("code", "debug"), "Expected 'code' and 'debug' to be anagrams.");
		assertFalse(anagramCheck.isAnagram("live", "leave"), "Expected 'live' and 'leave' to be anagrams.");
	}

}
