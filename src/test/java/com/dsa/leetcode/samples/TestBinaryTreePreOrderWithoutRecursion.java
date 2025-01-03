package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestBinaryTreePreOrderWithoutRecursion {

	private BinaryTreePreOrderWithoutRecursion binaryTree;

	@BeforeEach
	public void setUp() {
		binaryTree = new BinaryTreePreOrderWithoutRecursion();
	}

	@Test
	public void testEmptyTree() {
		TreeNode root = null;
		List<Integer> expected = Arrays.asList();
		List<Integer> result = binaryTree.preOrderWithoutRecursion(root);
		assertEquals(expected, result, "Pre-order traversal of an empty tree should return an empty list.");
	}

	@Test
	public void testSingleNodeTree() {
		TreeNode root = new TreeNode(1);
		List<Integer> expected = Arrays.asList(1);
		List<Integer> result = binaryTree.preOrderWithoutRecursion(root);
		assertEquals(expected, result, "Pre-order traversal of a single node tree should return the node value.");
	}

	@Test
	public void testLeftSkewedTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		List<Integer> expected = Arrays.asList(1, 2, 3);
		List<Integer> result = binaryTree.preOrderWithoutRecursion(root);
		assertEquals(expected, result,
				"Pre-order traversal of a left skewed tree should return values in the correct order.");
	}

	@Test
	public void testRightSkewedTree() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
		List<Integer> expected = Arrays.asList(1, 2, 3);
		List<Integer> result = binaryTree.preOrderWithoutRecursion(root);
		assertEquals(expected, result,
				"Pre-order traversal of a right skewed tree should return values in the correct order.");
	}

	@Test
	public void testFullBinaryTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		List<Integer> expected = Arrays.asList(1, 2, 4, 5, 3, 6, 7);
		List<Integer> result = binaryTree.preOrderWithoutRecursion(root);
		assertEquals(expected, result,
				"Pre-order traversal of a full binary tree should return values in the correct order.");
	}

	@Test
	public void testUnbalancedBinaryTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		List<Integer> expected = Arrays.asList(1, 2, 4, 3, 5);
		List<Integer> result = binaryTree.preOrderWithoutRecursion(root);
		assertEquals(expected, result,
				"Pre-order traversal of an unbalanced binary tree should return values in the correct order.");
	}
}