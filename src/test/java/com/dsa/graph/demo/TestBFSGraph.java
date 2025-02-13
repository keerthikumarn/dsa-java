package com.dsa.graph.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.junit.jupiter.api.Test;

class TestBFSGraph {

    @Test
    void bfsTraversalFromStartNode() {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        List<Integer> expectedOrder = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> actualOrder = bfsTraversal(graph, 1);

        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    void bfsTraversalWithDisconnectedGraph() {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        List<Integer> expectedOrder = Arrays.asList(1, 2);
        List<Integer> actualOrder = bfsTraversal(graph, 1);

        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    void bfsTraversalWithSingleNode() {
        Graph graph = new Graph();
        graph.addEdge(1, 1);

        List<Integer> expectedOrder = Collections.singletonList(1);
        List<Integer> actualOrder = bfsTraversal(graph, 1);

        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    void bfsTraversalWithNoEdges() {
        Graph graph = new Graph();
        graph.addEdge(1, 1);

        List<Integer> expectedOrder = Collections.singletonList(1);
        List<Integer> actualOrder = bfsTraversal(graph, 1);

        assertEquals(expectedOrder, actualOrder);
    }

    private List<Integer> bfsTraversal(Graph graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> order = new ArrayList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            order.add(currNode);
            for (int neighbour : graph.getNeighbors(currNode)) {
                if (!visited.contains(neighbour)) {
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }
        return order;
    }
}
