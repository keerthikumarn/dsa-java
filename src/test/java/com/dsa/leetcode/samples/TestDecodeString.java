package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDecodeString {
	
	private DecodeString decoder;
	
	@BeforeEach
	void setUp() {
		decoder = new DecodeString();
	}

    @Test
    void testSimpleEncoding() {
        assertEquals("aaabcbc", decoder.decodeString("3[a]2[bc]"));
    }

    @Test
    void testNestedEncoding() {
        assertEquals("accaccacc", decoder.decodeString("3[a2[c]]"));
    }

    @Test
    void testMultipleGroups() {
        assertEquals("abcabccdcdcdef", decoder.decodeString("2[abc]3[cd]ef"));
    }

    @Test
    void testSingleCharacter() {
        assertEquals("aaaa", decoder.decodeString("4[a]"));
    }

    @Test
    void testComplexNestedEncoding() {
        assertEquals("ababcababcababc", decoder.decodeString("3[2[ab]c]"));
    }


}
