package com.dsa.leetcode.samples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMinDepthOfBinaryTree {

	@Test
	void testMinDepthEmptyTree() {
		TreeNode root = null;
		assertEquals(0, MinDepthOfBinaryTree.minDepth(root));
	}

	@Test
	void testMinDepthWithSingleNode() {
		TreeNode root = new TreeNode(1);
		assertEquals(1, MinDepthOfBinaryTree.minDepth(root));
	}

	@Test
	void testMinDepthLeftSkewedTree() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
		assertEquals(3, MinDepthOfBinaryTree.minDepth(root));
	}

	@Test
	void testMinDepthBalancedTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		assertEquals(2, MinDepthOfBinaryTree.minDepth(root));
	}

	@Test
	void testMinDepthUnevenTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.right = new TreeNode(3);
		assertEquals(2, MinDepthOfBinaryTree.minDepth(root));
	}

}
