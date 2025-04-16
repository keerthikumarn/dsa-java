package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSearch2DMatrix {

	private Search2DMatrix search2DMatrix;

	@BeforeEach
	void setUp() throws Exception {
		search2DMatrix = new Search2DMatrix();
	}
	
	public void testElementExistsInMiddle() {
        int[][] matrix = {
            {1, 2, 4, 8},
            {10, 11, 12, 13},
            {14, 20, 30, 40}
        };
        assertTrue(search2DMatrix.searchMatrixBSApproach(matrix, 20));
    }

    @Test
    public void testElementExistsAtStart() {
        int[][] matrix = {
            {1, 2, 4},
            {5, 6, 7}
        };
        assertTrue(search2DMatrix.searchMatrixBSApproach(matrix, 1));
    }

    @Test
    public void testElementExistsAtEnd() {
        int[][] matrix = {
            {1, 2, 4},
            {5, 6, 7}
        };
        assertTrue(search2DMatrix.searchMatrixBSApproach(matrix, 7));
    }

    @Test
    public void testElementDoesNotExist() {
        int[][] matrix = {
            {1, 3, 5},
            {7, 9, 11}
        };
        assertFalse(search2DMatrix.searchMatrixBSApproach(matrix, 4));
    }

    @Test
    public void testEmptyMatrix() {
        int[][] matrix = new int[0][0];
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
        search2DMatrix.searchMatrixBSApproach(matrix, 5)
        );
    }

    @Test
    public void testSingleElementMatrixFound() {
        int[][] matrix = {
            {42}
        };
        assertTrue(search2DMatrix.searchMatrixBSApproach(matrix, 42));
    }

    @Test
    public void testSingleElementMatrixNotFound() {
        int[][] matrix = {
            {42}
        };
        assertFalse(search2DMatrix.searchMatrixBSApproach(matrix, 24));
    }
 }
