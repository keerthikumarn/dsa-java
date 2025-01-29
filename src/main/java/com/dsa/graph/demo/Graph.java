package com.dsa.graph.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

	private List<List<Node>> adjList = new ArrayList<>();

	private Map<Integer, List<Integer>> adjacentList = new HashMap<>();
	
	public Graph() {
		
	}

	public void addEdge(int node, int vertex) {
		adjacentList.putIfAbsent(node, new ArrayList<>());
		adjacentList.putIfAbsent(vertex, new ArrayList<>());
		adjacentList.get(node).add(vertex);
		adjacentList.get(vertex).add(node);
	}

	public Graph(List<Edge> edges) {
		for (int idx = 0; idx < edges.size(); idx++) {
			adjList.add(idx, new ArrayList<>());
		}

		for (Edge edge : edges) {
			adjList.get(edge.source).add(new Node(edge.destination, edge.weight));
		}
	}
	
	public List<Integer> getNeighbors(int node) {
        return adjacentList.getOrDefault(node, new ArrayList<>());
    }

    public void printGraph() {
    	adjacentList.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

	public void printGraph(Graph graph) {
		int srcVertex = 0;
		int adjListSize = graph.adjList.size();
		System.out.println("The contents of the graph:");
		while (srcVertex < adjListSize) {
			for (Node edge : graph.adjList.get(srcVertex)) {
				System.out.print("Vertex:" + srcVertex + " ==> " + edge.value + " (" + edge.weight + ")\t");
			}
			System.out.println();
			srcVertex++;
		}
	}
}
