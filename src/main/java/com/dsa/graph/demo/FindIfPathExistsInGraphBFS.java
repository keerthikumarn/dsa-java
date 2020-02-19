package com.dsa.graph.demo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindIfPathExistsInGraphBFS {

	public boolean validPath(int n, int[][] edges, int source, int destination) {
		boolean[][] graph = new boolean[n][n];
		for (boolean[] row : graph) {
			Arrays.fill(row, false);
		}
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			graph[u][v] = true;
			graph[v][u] = true;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		boolean[] visited = new boolean[n];
		for (int idx = 0; idx < n; idx++) {
			visited[idx] = false;
		}
		while (!queue.isEmpty()) {
			int current = queue.remove();
			if (current == destination) {
				return true;
			}
			
			for (int idx = 0; idx < n; idx++) {
				if (graph[current][idx] && !visited[idx]) {
					queue.add(idx);
					visited[idx] = true;
				}
			}
		}
		return false;
	}

}
