package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBullsAndCows {

	private BullsAndCows game;

	@BeforeEach
	void setUp() {
		game = new BullsAndCows();
	}

	@Test
	void testGetHintCase1() {
		assertEquals("1A3B", game.getHint("1807", "7810"));
	}

	@Test
	void testGetHintCase2() {
		assertEquals("1A1B", game.getHint("1123", "0111"));
	}

	@Test
	void testGetHintExactMatch() {
		assertEquals("4A0B", game.getHint("1234", "1234"));
	}

	@Test
	void testGetHintNoMatch() {
		assertEquals("0A0B", game.getHint("5678", "1234"));
	}

	@Test
	void testGetHintAllCows() {
		assertEquals("0A4B", game.getHint("1234", "4321"));
	}

	@Test
	void testGetHintRepeatedNumbers() {
		assertEquals("2A2B", game.getHint("1122", "1221"));
	}

}
