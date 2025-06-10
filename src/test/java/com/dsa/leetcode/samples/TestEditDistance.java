package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestEditDistance {

	private EditDistance ed;
	
	@BeforeEach
	void setUp() {
		ed = new EditDistance();
	}
	
	@Test
    public void testExample1() {
        assertEquals(3, ed.minDistance("horse", "ros"));
    }

    @Test
    public void testExample2() {
        assertEquals(5, ed.minDistance("intention", "execution"));
    }

    @Test
    public void testSameStrings() {
        assertEquals(0, ed.minDistance("abc", "abc"));
    }

    @Test
    public void testOneEmptyString() {
        assertEquals(4, ed.minDistance("", "test"));
    }

    @Test
    public void testBothEmptyStrings() {
        assertEquals(0, ed.minDistance("", ""));
    }

    @Test
    public void testCaseSensitivity() {
        assertEquals(1, ed.minDistance("a", "A")); // 'a' to 'A' = replace
    }

}
