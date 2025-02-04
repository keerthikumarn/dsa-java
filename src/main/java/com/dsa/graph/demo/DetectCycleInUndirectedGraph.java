package com.dsa.graph.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInUndirectedGraph {

	public static void main(String[] args) {
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(1).add(2);
		adj.get(2).add(1);
		adj.get(2).add(3);
		adj.get(3).add(2);

		DetectCycleInUndirectedGraph obj = new DetectCycleInUndirectedGraph();
		boolean ans = obj.isCycle(4, adj);
		if (ans) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}

	private boolean isCycle(int vertex, List<List<Integer>> adj) {
		boolean visited[] = new boolean[vertex];
		Arrays.fill(visited, false);
		int[] parent = new int[vertex];
		Arrays.fill(parent, -1);
		for (int idx = 0; idx < vertex; idx++) {
			if (visited[idx] == false) {
				if (checkForCycle(adj, idx, visited, parent)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkForCycle(List<List<Integer>> adj, int idx, boolean[] visited, int[] parent) {
		Queue<GraphNode> queue = new LinkedList<>(); // BFS
		queue.add(new GraphNode(idx, -1));
		visited[idx] = true;
		while (!queue.isEmpty()) {
			// source node and its parent node
			int node = queue.peek().first;
			int par = queue.peek().second;
			queue.remove();

			// go to all the adjacent nodes
			for (Integer it : adj.get(node)) {
				if (visited[it] == false) {
					queue.add(new GraphNode(it, node));
					visited[it] = true;
				}
				// if adjacent node is visited and is not its own parent node
				else if (par != it) {
					return true;
				}
			}
		}
		return false;
	}

}

class GraphNode {
	int first;
	int second;

	public GraphNode(int first, int second) {
		this.first = first;
		this.second = second;
	}
}
