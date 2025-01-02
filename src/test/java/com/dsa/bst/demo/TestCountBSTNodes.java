package com.dsa.bst.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCountBSTNodes {

	@Test
	void testGetBSTCountAllNodesWithinRange() {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(50);
		root.left.left = new Node(1);
		root.right.left = new Node(40);
		root.right.right = new Node(100);
		int low = 1;
		int high = 100;
		int result = CountBSTNodes.getBSTCount(root, low, high);
		assertEquals(6, result, "All nodes should be counted");
	}

	@Test
	void testGetBSTCountSomeNodesWithinRange() {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(50);
		root.left.left = new Node(1);
		root.right.left = new Node(40);
		root.right.right = new Node(100);
		int low = 5;
		int high = 45;
		int result = CountBSTNodes.getBSTCount(root, low, high);
		assertNotEquals(4, result, "Only nodes within range 5 to 45 should be counted");
	}

	@Test
	void testGetBSTCountNoNodesWithinRange() {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(50);
		root.left.left = new Node(1);
		root.right.left = new Node(40);
		root.right.right = new Node(100);
		int low = 200;
		int high = 300;
		int result = CountBSTNodes.getBSTCount(root, low, high);
		assertEquals(0, result, "No nodes should be counted");
	}

	@Test
	void testGetBSTCountEmptyTree() {
		Node root = null;
		int low = 1;
		int high = 100;
		int result = CountBSTNodes.getBSTCount(root, low, high);
		assertEquals(0, result, "Empty tree should return count 0");
	}

	@Test
	void testGetBSTCountSingleNodeInRange() {
		Node root = new Node(10);
		int low = 5;
		int high = 15;
		int result = CountBSTNodes.getBSTCount(root, low, high);
		assertEquals(1, result, "Single node within range should be counted");
	}

	@Test
	void testGetBSTCountSingleNodeOutOfRange() {
		Node root = new Node(10);
		int low = 20;
		int high = 30;
		int result = CountBSTNodes.getBSTCount(root, low, high);
		assertEquals(0, result, "Single node out of range should not be counted");
	}
}