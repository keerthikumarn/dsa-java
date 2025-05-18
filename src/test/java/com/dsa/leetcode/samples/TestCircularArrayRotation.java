package com.dsa.leetcode.samples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCircularArrayRotation {

	private CircularArrayRotation rotation;
	
	@BeforeEach
	public void setUp() {
		rotation = new CircularArrayRotation();
	}
	
	@Test
    public void testBasicRotation() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        int k = 2;
        List<Integer> queries = Arrays.asList(0, 1, 2);
        List<Integer> expected = Arrays.asList(2, 3, 1);
        assertEquals(expected, rotation.circularArrayRotation(input, k, queries));
    }

    @Test
    public void testZeroRotation() {
        List<Integer> input = Arrays.asList(4, 5, 6);
        int k = 0;
        List<Integer> queries = Arrays.asList(0, 1, 2);
        List<Integer> expected = Arrays.asList(4, 5, 6);
        assertEquals(expected, rotation.circularArrayRotation(input, k, queries));
    }

    @Test
    public void testFullRotation() {
        List<Integer> input = Arrays.asList(7, 8, 9);
        int k = 3; // same as size
        List<Integer> queries = Arrays.asList(0, 1, 2);
        List<Integer> expected = Arrays.asList(7, 8, 9);
        assertEquals(expected, rotation.circularArrayRotation(input, k, queries));
    }

    @Test
    public void testRotationMoreThanSize() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        int k = 7; // 7 % 5 = 2
        List<Integer> queries = Arrays.asList(0, 2, 4);
        List<Integer> expected = Arrays.asList(4, 1, 3);
        assertEquals(expected, rotation.circularArrayRotation(input, k, queries));
    }

    @Test
    public void testSingleElement() {
        List<Integer> input = Collections.singletonList(10);
        int k = 5;
        List<Integer> queries = Collections.singletonList(0);
        List<Integer> expected = Collections.singletonList(10);
        assertEquals(expected, rotation.circularArrayRotation(input, k, queries));
    }

    @Test
    public void testEmptyQueries() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        int k = 2;
        List<Integer> queries = Collections.emptyList();
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, rotation.circularArrayRotation(input, k, queries));
    }

    @Test
    public void testAllIndexesQueriedAfterRotation() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4);
        int k = 1;
        List<Integer> queries = Arrays.asList(0, 1, 2, 3);
        List<Integer> expected = Arrays.asList(4, 1, 2, 3);
        assertEquals(expected, rotation.circularArrayRotation(input, k, queries));
    }

}
