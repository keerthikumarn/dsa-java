package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBeautifulDaysAtMovies {
	
	private BeautifulDaysAtMovies bdm = null;
	
	@BeforeEach
	void setUp() throws Exception {
		bdm = new BeautifulDaysAtMovies();
	}

	@Test
    void beautifulDaysInRange() {
        assertEquals(2, bdm.beautifulDays(20, 23, 6));
    }

    @Test
    void beautifulDaysSingleDay() {
        assertEquals(1, bdm.beautifulDays(21, 21, 1));
    }

    @Test
    void beautifulDaysNoBeautifulDays() {
        assertEquals(1, bdm.beautifulDays(10, 12, 5));
    }

    @Test
    void beautifulDaysAllBeautifulDays() {
        assertEquals(3, bdm.beautifulDays(1, 3, 1));
    }

    @Test
    void beautifulDaysLargeRange() {
        BeautifulDaysAtMovies bdm = new BeautifulDaysAtMovies();
        assertEquals(100, bdm.beautifulDays(1, 100, 3));
    }

}
