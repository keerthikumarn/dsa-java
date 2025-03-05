package com.dsa.graph.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestNumberOfIslands {
	
	private NumberOfIslands numberOfIslands;
	
	@BeforeEach
	void setUp() {
		numberOfIslands = new NumberOfIslands();
	}
	
	@Test
	void returnsZeroWhenGridIsEmpty() {
		int[][] grid = new int[][] {};
		assertEquals(0, numberOfIslands.numberOfIsland(grid));
	}

}
