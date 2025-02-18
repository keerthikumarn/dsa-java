package com.dsa.graph.demo;

import java.util.Arrays;

public class FindIfPathExistsInGraph {

	/*public boolean validPath(int n, int[][] edges, int source, int destination) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
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
		if (source == destination) {
			return true;
		}
		visited.add(source);
		for (int neighbour : graph.getOrDefault(source, new ArrayList<>())) {
            if (!visited.contains(neighbour)) {
                if (dfs(neighbour, destination, graph, visited)) {
                    return true;
                }
            }
		} 
		return false;
	}*/
	
	public boolean validPath(int n, int[][] edges, int source, int destination) {
		boolean[][] graph = new boolean[n][n];
		for (boolean[] row : graph) {
			Arrays.fill(row, false);
		}
		
		for(int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			graph[u][v] = true;
			graph[v][u] = true;
		}
		
		boolean[] visited = new boolean[n];
		return dfs(source, destination, graph, visited, n);
	}

	private boolean dfs(int source, int destination, boolean[][] graph, boolean[] visited, int n) {
		for (int idx = 0; idx < n; idx++) {
			if (graph[source][idx] && !visited[idx]) {
				if (idx == destination) {
					return true;
				}
				visited[idx] = true;
				if (dfs(idx, destination, graph, visited, n)) {
					return true;
				}
			}
		}
		return false;
	}

	

}
