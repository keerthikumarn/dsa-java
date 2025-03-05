package com.dsa.graph.demo;

public class NumberOfIslands {

	public static void main(String args[]) {

		int graph[][] = { { 1, 1, 0, 1, 0 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 },
				{ 1, 0, 0, 0, 0 } };
		NumberOfIslands island = new NumberOfIslands();
		int count = island.numberOfIsland(graph);
		System.out.println(count);
	}

	public int numberOfIsland(int[][] graph) {
		boolean visited[][] = new boolean[graph.length][graph[0].length];
		int count = 0;
		for (int idx = 0; idx < graph.length; idx++) {
			for (int jdx = 0; jdx < graph[0].length; jdx++) {
				if (graph[idx][jdx] == 1 && !visited[idx][jdx]) {
					dfs(graph, idx, jdx, visited);
					count++;
				}
			}
		}
		return count;
	}

	private void dfs(int[][] graph, int idx, int jdx, boolean[][] visited) {
		if (idx < 0 || idx >= graph.length || jdx < 0 || jdx >= graph[0].length || graph[idx][jdx] == 0
				|| visited[idx][jdx]) {
			return;
		}
		visited[idx][jdx] = true;
		dfs(graph, idx + 1, jdx, visited);
		dfs(graph, idx - 1, jdx, visited);
		dfs(graph, idx, jdx + 1, visited);
		dfs(graph, idx, jdx - 1, visited);
	}
}
