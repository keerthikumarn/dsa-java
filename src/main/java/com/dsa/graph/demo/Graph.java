package com.dsa.graph.demo;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	List<List<Node>> adjList = new ArrayList<>();

	public Graph(List<Edge> edges) {
		for (int idx = 0; idx < edges.size(); idx++) {
			adjList.add(idx, new ArrayList<>());
		}

		for (Edge edge : edges) {
			adjList.get(edge.source).add(new Node(edge.destination, edge.weight));
		}
	}

	public void printGraph(Graph graph) {
		int srcVertex = 0;
		int adjListSize = graph.adjList.size();
		System.out.println("The contents of the graph:");
		while (srcVertex < adjListSize) {
			for(Node edge : graph.adjList.get(srcVertex)) {
				System.out.print("Vertex:" + srcVertex + " ==> " + edge.value + 
                        " (" + edge.weight + ")\t");
			}
		}

	}
}
