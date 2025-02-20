package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRussianPeasantsProblem {

	private RussianPeasantsProblem russianPeasantsProblem = null;

	@BeforeEach
	void setUp() {
		russianPeasantsProblem = new RussianPeasantsProblem();
	}

	@Test
	void russianPeasantsPositiveNumbers() {
		assertEquals(180, russianPeasantsProblem.russianPeasants(12, 15));
	}

	@Test
	void russianPeasantsOneZero() {
		assertEquals(0, russianPeasantsProblem.russianPeasants(0, 15));
	}

	@Test
	void russianPeasantsBothZeros() {
		assertEquals(0, russianPeasantsProblem.russianPeasants(0, 0));
	}

	@Test
	void russianPeasantsNegativeNumbers() {
		assertEquals(0, russianPeasantsProblem.russianPeasants(-12, 15));
	}

	@Test
	void russianPeasantsMixedSignNumbers() {
		assertEquals(0, russianPeasantsProblem.russianPeasants(12, -15));
	}

	@Test
	void russianPeasantsLargeNumbers() {
		assertEquals(2000000000, russianPeasantsProblem.russianPeasants(100000, 20000));
	}

}
