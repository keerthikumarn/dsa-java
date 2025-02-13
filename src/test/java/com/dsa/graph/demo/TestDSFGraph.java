package com.dsa.graph.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class TestDFSGraph {

    @Test
    void dfsTraversalFromStartNode() {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        Set<Integer> visited = new HashSet<>();
        dfsTraversal(graph, 1, visited);

        Set<Integer> expectedVisited = new HashSet<>(Arrays.asList(1, 2, 4, 3, 5));
        assertEquals(expectedVisited, visited);
    }

    @Test
    void dfsTraversalWithDisconnectedGraph() {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        Set<Integer> visited = new HashSet<>();
        dfsTraversal(graph, 1, visited);

        Set<Integer> expectedVisited = new HashSet<>(Arrays.asList(1, 2));
        assertEquals(expectedVisited, visited);
    }

    @Test
    void dfsTraversalWithSingleNode() {
        Graph graph = new Graph();
        graph.addEdge(1, 1);

        Set<Integer> visited = new HashSet<>();
        dfsTraversal(graph, 1, visited);

        Set<Integer> expectedVisited = Collections.singleton(1);
        assertEquals(expectedVisited, visited);
    }

    @Test
    void dfsTraversalWithNoEdges() {
        Graph graph = new Graph();

        Set<Integer> visited = new HashSet<>();
        dfsTraversal(graph, 1, visited);

        Set<Integer> expectedVisited = Collections.singleton(1);
        assertEquals(expectedVisited, visited);
    }

    private void dfsTraversal(Graph graph, int start, Set<Integer> visited) {
        if (visited.contains(start)) {
            return;
        }
        visited.add(start);
        for (int neighbor : graph.getNeighbors(start)) {
            dfsTraversal(graph, neighbor, visited);
        }
    }
}
