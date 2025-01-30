package com.dsa.graph.demo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFSGraph {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);

		System.out.println("BFS Traversal:");
		bfsGraph(graph, 1);
	}

	private static void bfsGraph(Graph graph, int start) {
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		queue.add(start);
		visited.add(start);

		while (!queue.isEmpty()) {
			int currNode = queue.poll();
			System.out.println(currNode + " ");
			for (int neighbour : graph.getNeighbors(currNode)) {
				if (!visited.contains(neighbour)) {
					queue.add(neighbour);
					visited.add(neighbour);
				}
			}
		}
	}

}
