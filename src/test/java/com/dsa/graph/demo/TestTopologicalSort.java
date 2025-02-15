package com.dsa.graph.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.junit.jupiter.api.Test;

class TestTopologicalSort {

	@Test
	void topologicalSortWithSimpleGraph() {
		Graph graph = new Graph();
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);

		Stack<Integer> stack = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		for (int neighbour : graph.getNeighbors(1)) {
			TopologicalSort.topologicalSort(graph, neighbour, visited, stack);
		}

		List<Integer> expectedOrder = Arrays.asList(2, 1, 3, 4);
		List<Integer> actualOrder = new ArrayList<>();
		while (!stack.isEmpty()) {
			actualOrder.add(stack.pop());
		}

		assertEquals(expectedOrder, actualOrder);
	}

	@Test
	void topologicalSortWithDisconnectedGraph() {
		Graph graph = new Graph();
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);

		Stack<Integer> stack = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		for (int neighbour : graph.getNeighbors(1)) {
			TopologicalSort.topologicalSort(graph, neighbour, visited, stack);
		}

		List<Integer> expectedOrder = Arrays.asList(2, 1);
		List<Integer> actualOrder = new ArrayList<>();
		while (!stack.isEmpty()) {
			actualOrder.add(stack.pop());
		}

		assertEquals(expectedOrder, actualOrder);
	}

	@Test
	void topologicalSortWithSingleNode() {
		Graph graph = new Graph();
		graph.addEdge(1, 1);

		Stack<Integer> stack = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		for (int neighbour : graph.getNeighbors(1)) {
			TopologicalSort.topologicalSort(graph, neighbour, visited, stack);
		}

		List<Integer> expectedOrder = Collections.singletonList(1);
		List<Integer> actualOrder = new ArrayList<>();
		while (!stack.isEmpty()) {
			actualOrder.add(stack.pop());
		}

		assertEquals(expectedOrder, actualOrder);
	}

	@Test
	void topologicalSortWithNoEdges() {
		Graph graph = new Graph();

		Stack<Integer> stack = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		for (int neighbour : graph.getNeighbors(1)) {
			TopologicalSort.topologicalSort(graph, neighbour, visited, stack);
		}

		List<Integer> expectedOrder = Collections.emptyList();
		List<Integer> actualOrder = new ArrayList<>();
		while (!stack.isEmpty()) {
			actualOrder.add(stack.pop());
		}

		assertEquals(expectedOrder, actualOrder);
	}
}
