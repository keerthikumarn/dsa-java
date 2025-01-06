package com.dsa.bst.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestKthLargestInBST {

	@BeforeEach
	public void setUp() {
		KthLargestElementInBST.count = 0;
		KthLargestElementInBST.result = -1;
	}

	@Test
	public void testKthLargestWithEmptyTree() {
		Node root = null;
		assertEquals(-1, KthLargestElementInBST.kthLargest(root, 1), "Empty tree should return -1 for any k");
	}

	@Test
	void test1stLargest() {
		Node root = createSampleBST();
		assertEquals(80, KthLargestElementInBST.kthLargest(root, 1), "1st largest should be 80");
	}

	@Test
	void test2ndLargest() {
		Node root = createSampleBST();
		assertEquals(70, KthLargestElementInBST.kthLargest(root, 2), "2nd largest should be 70");
	}

	@Test
	void test3rdLargest() {
		Node root = createSampleBST();
		assertEquals(60, KthLargestElementInBST.kthLargest(root, 3), "3rd largest should be 60");
	}

	private Node createSampleBST() {
		Node root = new Node(50);
		root.left = new Node(30);
		root.right = new Node(70);
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		root.right.left = new Node(60);
		root.right.right = new Node(80);
		return root;
	}

}
