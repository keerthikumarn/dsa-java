package com.dsa.graph.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestindIfPathExistsInGraphBFS {

	@Test
	void testValidPathExists() {
		FindIfPathExistsInGraphBFS findIfPathExistsInGraphBFS = new FindIfPathExistsInGraphBFS();
		int n = 3;
		int[][] edges = { { 0, 1 }, { 1, 2 } };
		int source = 0;
		int destination = 2;
		assertTrue(findIfPathExistsInGraphBFS.validPath(n, edges, source, destination));
	}

	@Test
	void testVaidPathDoesNotExists() {
		FindIfPathExistsInGraphBFS findIfPathExistsInGraphBFS = new FindIfPathExistsInGraphBFS();
		int n = 3;
		int[][] edges = { { 0, 1 }, { 1, 2 } };
		int source = 0;
		int destination = 3;
		assertFalse(findIfPathExistsInGraphBFS.validPath(n, edges, source, destination));
	}

	@Test
	void validPahtExistsInSingleNode() {
		FindIfPathExistsInGraphBFS findIfPathExistsInGraphBFS = new FindIfPathExistsInGraphBFS();
		int n = 1;
		int[][] edges = {};
		int source = 0;
		int destination = 0;
		assertTrue(findIfPathExistsInGraphBFS.validPath(n, edges, source, destination));
	}

	@Test
	void validPathExistsNoEdges() {
		FindIfPathExistsInGraphBFS findIfPathExistsInGraphBFS = new FindIfPathExistsInGraphBFS();
		int n = 3;
		int[][] edges = {};
		int source = 0;
		int destination = 2;
		assertFalse(findIfPathExistsInGraphBFS.validPath(n, edges, source, destination));
	}

	@Test
	void validPathSelfLoop() {
        FindIfPathExistsInGraphBFS graphBFS = new FindIfPathExistsInGraphBFS();
        int n = 3;
        int[][] edges = {{0, 0}, {1, 2}};
        int source = 0;
        int destination = 0;

        assertTrue(graphBFS.validPath(n, edges, source, destination));
    }
}
