package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestGameOfThrones {

	private GameOfThrones gameOfThrones;

	@BeforeEach
	void setUp() throws Exception {
		gameOfThrones = new GameOfThrones();
	}

	@Test
	void returnsYesForPalindromePermutation() {
		String result = gameOfThrones.gameOfThrones("civic");
		assertEquals("YES", result);
	}

	@Test
	void returnsNoForNonPalindromePermutation() {
		String result = gameOfThrones.gameOfThrones("hello");
		assertEquals("NO", result);
	}

	@Test
	void returnsYesForSingleCharacterString() {
		String result = gameOfThrones.gameOfThrones("a");
		assertEquals("YES", result);
	}

	@Test
	void returnsYesForEmptyString() {
		String result = gameOfThrones.gameOfThrones("");
		assertEquals("YES", result);
	}

	@Test
	void returnsYesForEvenLengthPalindromePermutation() {
		String result = gameOfThrones.gameOfThrones("aabb");
		assertEquals("YES", result);
	}

	@Test
	void returnsNoForStringWithMoreThanOneOddFrequencyCharacter() {
		String result = gameOfThrones.gameOfThrones("abc");
		assertEquals("NO", result);
	}

	@Test
	void handlesStringWithAllSameCharacters() {
		String result = gameOfThrones.gameOfThrones("aaaa");
		assertEquals("YES", result);
	}

}
