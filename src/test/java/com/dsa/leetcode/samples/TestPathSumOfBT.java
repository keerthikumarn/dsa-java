package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPathSumOfBT {

	private PathSumOfBT obj;

	@BeforeEach
	void setUp() {
		obj = new PathSumOfBT();
	}

	@Test
	void returnsFalseWhenRootIsNull() {
		assertFalse(obj.hasPathSum(null, 10));
	}

	@Test
	void returnsTrueWhenSingleNodeEqualsTargetSum() {
		TreeNode root = new TreeNode(10);
		assertTrue(obj.hasPathSum(root, 10));
	}

	@Test
	void returnsFalseWhenSingleNodeNotEqualsTargetSum() {
		TreeNode root = new TreeNode(5);
		assertFalse(obj.hasPathSum(root, 10));
	}

	@Test
	void returnsTrueWhenPathSumExistsInLeftSubtree() {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		assertTrue(obj.hasPathSum(root, 22));
	}

	@Test
	void returnsTrueWhenPathSumExistsInRightSubtree() {
		TreeNode root = new TreeNode(5);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		assertTrue(obj.hasPathSum(root, 18));
	}

	@Test
	void returnsFalseWhenNoPathSumExists() {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		assertFalse(obj.hasPathSum(root, 27));
	}

}
