package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestValidateBinaryTree {

	@Test
	void testDiameterOfBinaryTreeSingleNode() {
		ValidateBinaryTree tree = new ValidateBinaryTree();
		TreeNode root = new TreeNode(1);
		boolean isValidBinaryTree = tree.isValidBST(root);
		assertTrue(isValidBinaryTree);
	}
	
	@Test
	void testDiameterOfBinaryTreeLinearTree() {
		ValidateBinaryTree tree = new ValidateBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		boolean isValidBinaryTree = tree.isValidBST(root);
		assertFalse(isValidBinaryTree);
	}
}
