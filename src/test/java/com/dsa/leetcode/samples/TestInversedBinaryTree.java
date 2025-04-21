package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestInversedBinaryTree {

	private final InversedBinaryTree treeInverter = new InversedBinaryTree();

	@Test
	public void testInvertTreeBalancedTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		TreeNode inverted = treeInverter.invertTree(root);
		assertEquals(1, inverted.val);
		assertEquals(3, inverted.left.val);
		assertEquals(2, inverted.right.val);
		assertEquals(7, inverted.left.left.val);
		assertEquals(6, inverted.left.right.val);
		assertEquals(5, inverted.right.left.val);
		assertEquals(4, inverted.right.right.val);
	}

	@Test
	public void testInvertTreeSingleNode() {
		TreeNode root = new TreeNode(42);
		TreeNode inverted = treeInverter.invertTree(root);
		assertNotNull(inverted);
		assertEquals(42, inverted.val);
		assertNull(inverted.left);
		assertNull(inverted.right);
	}

	@Test
	public void testInvertTreeNull() {
		TreeNode inverted = treeInverter.invertTree(null);
		assertNull(inverted);
	}

	@Test
	public void testInvertTreeLeftHeavy() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		TreeNode inverted = treeInverter.invertTree(root);
		assertEquals(1, inverted.val);
		assertNull(inverted.left);
		assertEquals(2, inverted.right.val);
		assertNull(inverted.right.left);
		assertEquals(3, inverted.right.right.val);
	}

}
