package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMaxPathSumOfBT {

	private MaxPathSumOfBT solver;

	@BeforeEach
	void setUp() {
		solver = new MaxPathSumOfBT();
	}

	@Test
	void testMaxPathSumSingleNode() {
		TreeNode root = new TreeNode(5);
		assertEquals(5, solver.maxPathSum(root));
	}

	@Test
	void testMaxPathSumTwoNodes() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		assertEquals(3, solver.maxPathSum(root));
	}

	@Test
	void testMaxPathSumThreeNodes() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		assertEquals(6, solver.maxPathSum(root));
	}

	@Test
	void testMaxPathSumWithNegativeValues() {
		TreeNode root = new TreeNode(-10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		assertEquals(42, solver.maxPathSum(root));
	}

	@Test
	void testMaxPathSumAllNegativeNodes() {
		TreeNode root = new TreeNode(-3);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(-1);
		assertEquals(-1, solver.maxPathSum(root));
	}

}
