package com.dsa.slidingwindow;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.dsa.slidingiwindow.FirstNegativeInteger;

class TestFirstNegativeInteger {

	private FirstNegativeInteger firstNegativeInteger;
	private ByteArrayOutputStream outputStream;

	@BeforeEach
	void setUp() {
		firstNegativeInteger = new FirstNegativeInteger();
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}

	@Test
	void testWithNegativeNumbers() {
		firstNegativeInteger.printFirstNegativeInteger(new int[] { 12, -1, -7, 8, -15, 30, 16, 28 }, 3);
		assertEquals("-1 -1 -7 -15 -15", outputStream.toString().trim());
	}

	@Test
	void testWithoutNegativeNumbers() {
		firstNegativeInteger.printFirstNegativeInteger(new int[] { 1, 2, 3, 4, 5 }, 3);
		assertEquals("0", outputStream.toString().trim());
	}

	@Test
	void testSingleElementWindow() {
		firstNegativeInteger.printFirstNegativeInteger(new int[] { -5, 3, -2, 4 }, 1);
		assertEquals("-5 -2", outputStream.toString().trim());
	}

	@Test
	void testWindowLargerThanArray() {
		firstNegativeInteger.printFirstNegativeInteger(new int[] { 1, -2, 3 }, 5);
		assertEquals("0", outputStream.toString().trim());
	}

	@Test
	void testEmptyArray() {
		firstNegativeInteger.printFirstNegativeInteger(new int[] {}, 3);
		assertEquals("0", outputStream.toString().trim());
	}
}
