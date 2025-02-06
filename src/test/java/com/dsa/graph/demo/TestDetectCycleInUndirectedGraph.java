package com.dsa.graph.demo;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestDetectCycleInUndirectedGraph {

	@Test
	void testIsCycleExists() {
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			adjList.add(new ArrayList<>());
		}
		adjList.get(0).add(1);
		adjList.get(1).add(0);
		adjList.get(1).add(2);
		adjList.get(2).add(1);
		adjList.get(2).add(3);
		adjList.get(3).add(2);
		adjList.get(3).add(0);
		adjList.get(0).add(3);
		DetectCycleInUndirectedGraph obj = new DetectCycleInUndirectedGraph();
		assertTrue(obj.isCycle(4, adjList), "Cycle should be detected");
	}

	@Test
	void testNoCycleExists() {
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			adjList.add(new ArrayList<>());
		}
		adjList.get(0).add(1);
		adjList.get(1).add(0);
		adjList.get(1).add(2);
		adjList.get(2).add(1);
		adjList.get(2).add(3);
		adjList.get(3).add(2);
		DetectCycleInUndirectedGraph obj = new DetectCycleInUndirectedGraph();
		assertFalse(obj.isCycle(4, adjList), "No cycle should be detected");
	}

	@Test
	void testSingleNodeNoEdges() {
		List<List<Integer>> adj = new ArrayList<>();
		adj.add(new ArrayList<>());
		DetectCycleInUndirectedGraph obj = new DetectCycleInUndirectedGraph();
		assertFalse(obj.isCycle(1, adj), "Single node without edges should be acyclic");
	}

	@Test
    void testDisconnectedGraphWithCycle() {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(5);
        adj.get(5).add(4);
        adj.get(5).add(3);
        adj.get(3).add(5);
        DetectCycleInUndirectedGraph obj = new DetectCycleInUndirectedGraph();
        assertTrue(obj.isCycle(6, adj), "Graph should contain a cycle in one of its components");
    }
}
