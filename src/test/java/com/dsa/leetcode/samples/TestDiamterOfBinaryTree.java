package com.dsa.leetcode.samples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestDiamterOfBinaryTree {

	@Test
	void testDiameterOfBinaryTreeSingleNode() {
		DiamterOfBinaryTree tree = new DiamterOfBinaryTree();
		TreeNode root = new TreeNode(1);
		int diameter = tree.diameterOfBinaryTree(root);
		assertEquals(0, diameter, "Diameter of a single-node tree should be 0");
	}

	@Test
	void testDiameterOfBinaryTreeLinearTree() {
		DiamterOfBinaryTree solution = new DiamterOfBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		int diameter = solution.diameterOfBinaryTree(root);
		assertEquals(2, diameter, "Diameter of a linear tree should be the number of edges");
	}

	@Test
	void testDiameterOfBinaryTreeBalancedTree() {
		DiamterOfBinaryTree solution = new DiamterOfBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		int diameter = solution.diameterOfBinaryTree(root);
		assertEquals(3, diameter, "Diameter of the tree should be the longest path between two leaf nodes");
	}

	@Test
	void testDiameterOfBinaryTreeComplexTree() {
		DiamterOfBinaryTree solution = new DiamterOfBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(6);
		int diameter = solution.diameterOfBinaryTree(root);
		assertEquals(4, diameter, "Diameter of the complex tree should be correctly calculated");
	}

	@Test
	void testDiameterOfBinaryTreeNullRoot() {
		DiamterOfBinaryTree solution = new DiamterOfBinaryTree();
		int diameter = solution.diameterOfBinaryTree(null);
		assertEquals(0, diameter, "Diameter of an empty tree should be 0");
	}

}
