package com.dsa.bst.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCheckIfTreeIsBST {

    private CheckIfTreeIsBST tree;

    @BeforeEach
    public void setUp() {
        tree = new CheckIfTreeIsBST();
    }

    @Test
    public void testEmptyTree() {
        assertTrue(tree.isBSTOrNot(), "An empty tree should be a BST");
    }

    @Test
    public void testSingleNodeTree() {
        tree.root = new Node(10);
        assertTrue(tree.isBSTOrNot(), "A single node tree should be a BST");
    }

    @Test
    public void testValidBST() {
        tree.root = new Node(100);
        tree.root.left = new Node(90);
        tree.root.right = new Node(110);
        tree.root.left.left = new Node(80);
        tree.root.left.right = new Node(95);
        assertTrue(tree.isBSTOrNot(), "This tree should be a valid BST");
    }

    @Test
    public void testInvalidBST() {
        tree.root = new Node(100);
        tree.root.left = new Node(110); // Invalid, as left child is greater
        tree.root.right = new Node(90);
        assertFalse(tree.isBSTOrNot(), "This tree should not be a valid BST");
    }

    @Test
    public void testComplexValidBST() {
        tree.root = new Node(15);
        tree.root.left = new Node(10);
        tree.root.right = new Node(20);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(12);
        tree.root.right.left = new Node(18);
        tree.root.right.right = new Node(25);
        assertTrue(tree.isBSTOrNot(), "This complex tree should be a valid BST");
    }

    @Test
    public void testComplexInvalidBST() {
        tree.root = new Node(15);
        tree.root.left = new Node(10);
        tree.root.right = new Node(20);
        tree.root.left.right = new Node(17); // Invalid, as this should be less than 20
        assertFalse(tree.isBSTOrNot(), "This complex tree should not be a valid BST");
    }
}
