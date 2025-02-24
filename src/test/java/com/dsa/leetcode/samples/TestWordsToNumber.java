package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestWordsToNumber {

	
	@Test
	void testWordToNumberZero() {
		assertEquals(0, WordsToNumber.wordsToNumber("zero"));
	}
	
	@Test
	void testWordToNumerSingleDigit() {
		assertEquals(9, WordsToNumber.wordsToNumber("nine"));
	}
	
	@Test
	void testWordToNumerTwoDigit() {
		assertEquals(38, WordsToNumber.wordsToNumber("thirty eight"));
	}
	
	@Test
	void testWordToNumberThreeDigits() {
		assertEquals(123, WordsToNumber.wordsToNumber("one hundred twenty three"));
	}
	
	@Test
	void testWordToNumberFourDigits() {
		assertEquals(4005, WordsToNumber.wordsToNumber("four thousand five"));
	}
	
	

}
