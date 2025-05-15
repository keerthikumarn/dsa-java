package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestIsSubTree {

	private IsSubTree isSubTree = null;
	
	@BeforeEach
	void setUp() {
		isSubTree = new IsSubTree();
	}

	// Helper method to build tree nodes
	private TreeNode createTree(Integer... values) {
		if (values.length == 0 || values[0] == null)
			return null;
		TreeNode[] nodes = new TreeNode[values.length];
		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				nodes[i] = new TreeNode(values[i]);
			}
		}
		for (int i = 0; i < values.length; i++) {
			if (nodes[i] != null) {
				int left = 2 * i + 1;
				int right = 2 * i + 2;
				if (left < values.length)
					nodes[i].left = nodes[left];
				if (right < values.length)
					nodes[i].right = nodes[right];
			}
		}
		return nodes[0];
	}

	@Test
	public void testSubtreeIsNull() {
		TreeNode root = createTree(3, 4, 5, 1, 2);
		assertTrue(isSubTree.isSubtree(root, null), "Null subtree should return true");
	}

	@Test
	public void testRootIsNull() {
		TreeNode subRoot = createTree(1);
		assertFalse(isSubTree.isSubtree(null, subRoot), "Non-null subtree with null root should return false");
	}

	@Test
	public void testSameTree() {
		TreeNode root = createTree(1, 2, 3);
		TreeNode subRoot = createTree(1, 2, 3);
		assertTrue(isSubTree.isSubtree(root, subRoot), "Identical trees should be considered a subtree");
	}

	@Test
	public void testIsSubtree() {
		TreeNode root = createTree(3, 4, 5, 1, 2);
		TreeNode subRoot = createTree(4, 1, 2);
		assertTrue(isSubTree.isSubtree(root, subRoot), "Valid subtree should return true");
	}

	@Test
	public void testIsNotSubtree() {
		TreeNode root = createTree(3, 4, 5, 1, 2, null, null, 0);
		TreeNode subRoot = createTree(4, 1, 2);
		assertFalse(isSubTree.isSubtree(root, subRoot), "Incorrect structure should return false");
	}

	@Test
	public void testSubtreeWithDifferentStructure() {
		TreeNode root = createTree(3, 4, 5, 1, null, 2);
		TreeNode subRoot = createTree(4, 1, 2);
		assertFalse(isSubTree.isSubtree(root, subRoot), "Same values with different structure should return false");
	}

}
