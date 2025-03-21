package com.dsa.tree.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTreeNodesDisplay {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testSingleRootNode() {
        MyTreeNode root = new MyTreeNode("1");
        TreeNodesDisplay.printNodes(root);
        assertEquals("Visited nodes: 1 |", outputStream.toString().trim());
    }

    @Test
    void testMultipleNodes() {
        MyTreeNode root = new MyTreeNode("1");
        MyTreeNode child1 = new MyTreeNode("2");
        MyTreeNode child2 = new MyTreeNode("3");
        root.setChildNodes(Arrays.asList(child1, child2));
        
        TreeNodesDisplay.printNodes(root);
        String output = outputStream.toString().trim();
        assertTrue(output.contains("1 | 2 | 3 |"));
    }

    @Test
    void testTreeWithCycles() {
        MyTreeNode root = new MyTreeNode("1");
        MyTreeNode child1 = new MyTreeNode("2");
        MyTreeNode child2 = new MyTreeNode("3");
        root.setChildNodes(Arrays.asList(child1, child2));
        child1.setChildNodes(Arrays.asList(root));
        TreeNodesDisplay.printNodes(root);
        String output = outputStream.toString().trim();
        assertTrue(output.contains("1 | 2 | 3 |"));
    }

}
