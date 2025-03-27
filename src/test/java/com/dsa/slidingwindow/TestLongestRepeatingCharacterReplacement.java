package com.dsa.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dsa.slidingiwindow.LongestRepeatingCharacterReplacement;

class TestLongestRepeatingCharacterReplacement {

	private LongestRepeatingCharacterReplacement obj;
	
	@BeforeEach
	void setUp() {
		obj = new LongestRepeatingCharacterReplacement();
	}
	
	@Test
    void testBasicCase() {
        assertEquals(4, obj.characterReplacementWithSW1("XYYX", 2));
    }

    @Test
    void testAllSameCharacters() {
        assertEquals(6, obj.characterReplacementWithSW1("AAAAAA", 2));
    }

    @Test
    void testNoReplacementsNeeded() {
        assertEquals(1, obj.characterReplacementWithSW1("ABAB", 0));
    }

    @Test
    void testSingleCharacterString() {
        assertEquals(1, obj.characterReplacementWithSW1("A", 1));
    }

    @Test
    void testEmptyString() {
        assertEquals(0, obj.characterReplacementWithSW1("", 2));
    }

}
