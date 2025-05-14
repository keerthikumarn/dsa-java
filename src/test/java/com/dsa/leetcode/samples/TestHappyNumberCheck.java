package com.dsa.leetcode.samples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestHappyNumberCheck {

	private HappyNumberCheck checker;
	
	@BeforeEach
	void setUp() throws Exception {
		checker = new HappyNumberCheck();
	}
	
	@Test
    public void testHappyNumber_19() {
        assertTrue(checker.isHappy(19));
    }

    @Test
    public void testUnhappyNumber_2() {
        assertFalse(checker.isHappy(2));
    }

    @Test
    public void testHappyNumber_1() {
        assertTrue(checker.isHappy(1));
    }

    @Test
    public void testLargeHappyNumber() {
        assertTrue(checker.isHappy(100));
    }

    @Test
    public void testLargeUnhappyNumber() {
        assertTrue(checker.isHappy(1111111));
    }

    @Test
    public void testEdgeCaseZero() {
        assertFalse(checker.isHappy(0));
    }

    @Test
    public void testSingleDigitUnhappy() {
        assertFalse(checker.isHappy(4));
    }

    @Test
    public void testSingleDigitHappy() {
        assertTrue(checker.isHappy(7));
    }

}
