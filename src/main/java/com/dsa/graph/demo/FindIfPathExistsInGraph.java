package com.dsa.graph.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindIfPathExistsInGraph {

	public static void main(String[] args) {

	}

	public boolean validPath(int n, int[][] edges, int source, int destination) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		// create an adjacency matrix
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
			graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
		}
		Set<Integer> visited = new HashSet<>();
		return dfs(source, destination, graph, visited);
	}

	private boolean dfs(int source, int destination, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
		// TODO Auto-generated method stub
		return false;
	}

}
