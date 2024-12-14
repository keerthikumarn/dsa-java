package com.dsa.leetcode.samples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestInvertBinaryTree {

	@Test
	void testInvertTree() {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		root.right = new TreeNode(7, new TreeNode(6), new TreeNode(9));

		TreeNode expectedRoot = new TreeNode(4);
		expectedRoot.left = new TreeNode(7, new TreeNode(9), new TreeNode(6));
		expectedRoot.right = new TreeNode(2, new TreeNode(3), new TreeNode(1));

		InvertBinaryTree tree = new InvertBinaryTree();
		TreeNode invertedTree = tree.invertTree(root);
		assertTrue(areTreesEqual(expectedRoot, invertedTree));
	}

	@Test
	void testInvertTreeWithSingleNode() {
		TreeNode root = new TreeNode(1);
		InvertBinaryTree inverter = new InvertBinaryTree();
		TreeNode invertedRoot = inverter.invertTree(root);
		assertEquals(root, invertedRoot, "Inverting a single-node tree should return the same tree");
	}

	private boolean areTreesEqual(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		}
		if (t1 == null || t2 == null || t1.val != t2.val) {
			return false;
		}
		return areTreesEqual(t1.left, t2.left) && areTreesEqual(t1.right, t2.right);
	}

}
