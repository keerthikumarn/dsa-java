package com.dsa.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dsa.slidingiwindow.FindDuplicatesWithinK;
import static org.junit.jupiter.api.Assertions.*;

class TestFindDuplicatesWithinK {

	private FindDuplicatesWithinK finder;
	
	@BeforeEach
	void setUp() {
		finder = new FindDuplicatesWithinK();
	}
	
	@Test
    void testDuplicateWithinK() {
        assertTrue(finder.findDuplicatesWithinK(new int[]{1, 2, 3, 1}, 3));
    }

    @Test
    void testNoDuplicateWithinK() {
        assertFalse(finder.findDuplicatesWithinK(new int[]{4, 5, 6, 7}, 3));
    }

    @Test
    void testDuplicateOutsideK() {
        assertFalse(finder.findDuplicatesWithinK(new int[]{1, 2, 3, 4, 1}, 2));
    }

    @Test
    void testEmptyArray() {
        assertFalse(finder.findDuplicatesWithinK(new int[]{}, 3));
    }

    @Test
    void testSingleElementArray() {
        assertFalse(finder.findDuplicatesWithinK(new int[]{1}, 3));
    }
}
