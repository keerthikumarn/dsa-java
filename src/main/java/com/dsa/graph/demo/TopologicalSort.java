package com.dsa.graph.demo;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);

		Stack<Integer> stack = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		for (int neighbour : graph.getNeighbors(1)) {
			topologicalSort(graph, neighbour, visited, stack);
		}
		System.out.println("Topological Sort Process....");
		while (!stack.isEmpty()) {
			System.out.println(stack.pop() + " ");
		}
	}

	private static void topologicalSort(Graph graph, int neighbour, Set<Integer> visited, Stack<Integer> stack) {
		if (visited.contains(neighbour)) {
			return;
		}
		visited.add(neighbour);
		for (int neighbor : graph.getNeighbors(neighbour)) {
			topologicalSort(graph, neighbor, visited, stack);
		}
		stack.push(neighbour);
	}

}
