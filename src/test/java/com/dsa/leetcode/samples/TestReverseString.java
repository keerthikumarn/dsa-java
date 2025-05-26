package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dsa.twopointers.StringReverse;

public class TestReverseString {

	private ReverseString reverser;

	@BeforeEach
	void setUp() {
		reverser = new ReverseString();
	}

	@Test
	public void testReverseString_NormalCase() {
		char[] input = { 'h', 'e', 'l', 'l', 'o' };
		char[] expected = { 'o', 'l', 'l', 'e', 'h' };
		reverser.reverseString(input);
		assertArrayEquals(expected, input);
	}

	@Test
	public void testReverseString_EvenLength() {
		char[] input = { 'a', 'b', 'c', 'd' };
		char[] expected = { 'd', 'c', 'b', 'a' };
		reverser.reverseString(input);
		assertArrayEquals(expected, input);
	}

	@Test
	public void testReverseString_SingleCharacter() {
		char[] input = { 'x' };
		char[] expected = { 'x' };
		reverser.reverseString(input);
		assertArrayEquals(expected, input);
	}

	@Test
	public void testReverseString_EmptyArray() {
		char[] input = {};
		char[] expected = {};
		reverser.reverseString(input);
		assertArrayEquals(expected, input);
	}

	@Test
	public void testReverseString_Palindrome() {
		char[] input = { 'm', 'a', 'd', 'a', 'm' };
		char[] expected = { 'm', 'a', 'd', 'a', 'm' };
		reverser.reverseString(input);
		assertArrayEquals(expected, input);
	}

}
