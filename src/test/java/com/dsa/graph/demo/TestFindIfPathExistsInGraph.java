package com.dsa.graph.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestFindIfPathExistsInGraph {

	@Test
	void testValidPath() {
		FindIfPathExistsInGraph obj = new FindIfPathExistsInGraph();
		int n = 3;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
		int source = 0;
		int destination = 2;
		assertTrue(obj.validPath(n, edges, source, destination));
	}
	
	@Test
	void testValidPath2() {
		FindIfPathExistsInGraph obj = new FindIfPathExistsInGraph();
		int n = 3;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
		int source = 0;
		int destination = 1;
		assertTrue(obj.validPath(n, edges, source, destination));
	}
	
	@Test
	void testValidPathNotExists() {
		FindIfPathExistsInGraph obj = new FindIfPathExistsInGraph();
		int n = 3;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
		int source = 0;
		int destination = 3;
		assertFalse(obj.validPath(n, edges, source, destination));
	}
	
	@Test
	void testValidPathWithSingleEdge() {
		FindIfPathExistsInGraph obj = new FindIfPathExistsInGraph();
		int n = 2;
		int[][] edges = { { 0, 1 } };
		int source = 0;
		int destination = 1;
		assertTrue(obj.validPath(n, edges, source, destination));
	}
	
	@Test
	void testValidPathWithDirectEdge() {
		FindIfPathExistsInGraph obj = new FindIfPathExistsInGraph();
		int n = 2;
		int[][] edges = { { 0, 1 } };
		int source = 1;
		int destination = 0;
		assertTrue(obj.validPath(n, edges, source, destination));
	}
	
	@Test
	void testValidPathWithNoEdge() {
		FindIfPathExistsInGraph obj = new FindIfPathExistsInGraph();
		int n = 2;
		int[][] edges = {};
		int source = 0;
		int destination = 1;
		assertFalse(obj.validPath(n, edges, source, destination));
	}

}
