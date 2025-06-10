package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestExcelColumnNumber {

	private ExcelColumnNumber converter;

	@BeforeEach
	void setUp() {
		converter = new ExcelColumnNumber();
	}

	@Test
	public void testSingleLetters() {
		assertEquals(1, converter.titleToNumber("A"));
		assertEquals(2, converter.titleToNumber("B"));
		assertEquals(26, converter.titleToNumber("Z"));
	}

	@Test
	public void testDoubleLetters() {
		assertEquals(27, converter.titleToNumber("AA"));
		assertEquals(28, converter.titleToNumber("AB"));
		assertEquals(52, converter.titleToNumber("AZ"));
		assertEquals(53, converter.titleToNumber("BA"));
	}

	@Test
	public void testTripleLetters() {
		assertEquals(703, converter.titleToNumber("AAA"));
		assertEquals(704, converter.titleToNumber("AAB"));
		assertEquals(728, converter.titleToNumber("AAZ"));
	}

	@Test
	public void testLargeColumn() {
		assertEquals(18278, converter.titleToNumber("ZZZ"));
	}

}
