package com.dsa.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.dsa.slidingiwindow.CountDistinctElements;

class TestCountDistinctElements {

	private CountDistinctElements obj;
	
	@BeforeEach
	void setUp() {
		obj = new CountDistinctElements();
	}
	
	@Test
    void testAllUniqueElements() {
        int[] window = {1, 2, 3, 4};
        assertEquals(4, obj.countWindowDistinct(window, 4));
    }

    @Test
    void testAllSameElements() {
        int[] window = {5, 5, 5, 5};
        assertEquals(1, obj.countWindowDistinct(window, 4));
    }

    @Test
    void testMixedElements() {
        int[] window = {1, 2, 1, 3};
        assertEquals(3, obj.countWindowDistinct(window, 4));
    }

    @Test
    void testSingleElement() {
        int[] window = {42};
        assertEquals(1, obj.countWindowDistinct(window, 1));
    }

    @Test
    void testWindowSizeLessThanArray() {
        int[] window = {1, 2, 1, 3, 4, 2, 3};
        int[] subWindow = new int[4];
        System.arraycopy(window, 0, subWindow, 0, 4);
        assertEquals(3, obj.countWindowDistinct(subWindow, 4));
    }

}
