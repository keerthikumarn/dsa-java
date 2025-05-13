package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBTLevelOrderTraversal {

	private BTLevelOrderTraversal traversal;

	@BeforeEach
	void setUp() throws Exception {
		traversal = new BTLevelOrderTraversal();
	}

	@Test
	public void testEmptyTree() {
		TreeNode root = null;
		List<List<Integer>> expected = Collections.emptyList();
		assertEquals(expected, traversal.levelOrder(root));
	}

	@Test
	public void testSingleNodeTree() {
		TreeNode root = new TreeNode(1);
		List<List<Integer>> expected = List.of(List.of(1));
		assertEquals(expected, traversal.levelOrder(root));
	}

	@Test
	public void testTwoLevelTree() {
		TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		List<List<Integer>> expected = List.of(List.of(1), List.of(2, 3));
		assertEquals(expected, traversal.levelOrder(root));
	}

	@Test
	public void testThreeLevelBalancedTree() {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
				new TreeNode(3, new TreeNode(6), new TreeNode(7)));

		List<List<Integer>> expected = List.of(List.of(1), List.of(2, 3), List.of(4, 5, 6, 7));
		assertEquals(expected, traversal.levelOrder(root));
	}

	@Test
	public void testLeftSkewedTree() {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), null);
		List<List<Integer>> expected = List.of(List.of(1), List.of(2), List.of(3), List.of(4));
		assertEquals(expected, traversal.levelOrder(root));
	}

	@Test
	public void testRightSkewedTree() {
		TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));

		List<List<Integer>> expected = List.of(List.of(1), List.of(2), List.of(3), List.of(4));

		assertEquals(expected, traversal.levelOrder(root));
	}

	@Test
	public void testUnbalancedTree() {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));

		List<List<Integer>> expected = List.of(List.of(1), List.of(2, 3), List.of(4));

		assertEquals(expected, traversal.levelOrder(root));
	}

}
