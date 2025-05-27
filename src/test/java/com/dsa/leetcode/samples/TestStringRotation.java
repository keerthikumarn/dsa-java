package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStringRotation {

	private StringRotation rotation;

	@BeforeEach
	void setUp() {
		rotation = new StringRotation();
	}

	@Test
	public void testValidRotation() {
		assertTrue(rotation.isRotation("waterbottle", "erbottlewat"));
		assertTrue(rotation.isRotation("rotation", "tionrota"));
		assertTrue(rotation.isRotation("abcde", "cdeab"));
	}

	@Test
	public void testInvalidRotation() {
		assertFalse(rotation.isRotation("waterbottle", "bottlewaterx"));
		assertFalse(rotation.isRotation("rotation", "tationroa"));
		assertFalse(rotation.isRotation("abcde", "abced"));
	}

	@Test
	public void testDifferentLengths() {
		assertFalse(rotation.isRotation("abc", "ab"));
		assertFalse(rotation.isRotation("abcde", "abcdef"));
	}

	@Test
	public void testNullInputs() {
		assertFalse(rotation.isRotation(null, "abc"));
		assertFalse(rotation.isRotation("abc", null));
		assertFalse(rotation.isRotation(null, null));
	}

	@Test
	public void testEmptyStrings() {
		assertTrue(rotation.isRotation("", ""));
	}

}
