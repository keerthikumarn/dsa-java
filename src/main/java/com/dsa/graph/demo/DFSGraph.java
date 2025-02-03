package com.dsa.graph.demo;

import java.util.HashSet;
import java.util.Set;

public class DFSGraph {
	
	private static void dfs(Graph graph, int start, Set<Integer> visited) {
        if (visited.contains(start)) {
        	return;
        }
        visited.add(start);
        System.out.print(start + " ");
        for (int neighbor : graph.getNeighbors(start)) {
            dfs(graph, neighbor, visited);
        }
    }

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		System.out.println("DFS Traversal:");
		dfs(graph, 1, new HashSet<>());
	}

}
