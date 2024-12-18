package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestpathSumOfBT {

	private final PathSumOfBT pathSum = new PathSumOfBT();

	@Test
	public void testHasPathSumEmptyTree() {
		assertFalse(pathSum.hasPathSum(null, 0), "Should return false for an empty tree");
	}
	
	@Test
    public void testHasPathSumSingleNodeMatchingSum() {
        TreeNode root = new TreeNode(5);
        assertTrue(pathSum.hasPathSum(root, 5), "Should return true for a single node matching the target sum");
    }

    @Test
    public void testHasPathSumSingleNodeNonMatchingSum() {
        TreeNode root = new TreeNode(5);
        assertFalse(pathSum.hasPathSum(root, 10), "Should return false for a single node not matching the target sum");
    }

    @Test
    public void testHasPathSumMultipleNodesWithPath() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        assertTrue(pathSum.hasPathSum(root, 22), "Should return true for a path that sums to 22");
    }

    @Test
    public void testHasPathSumMultipleNodesWithoutPath() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assertFalse(pathSum.hasPathSum(root, 5), "Should return false when no path sums to 5");
    }

    @Test
    public void testHasPathSum_NegativeValues() {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        assertTrue(pathSum.hasPathSum(root, -5), "Should return true for a path that sums to -5");
        assertFalse(pathSum.hasPathSum(root, -4), "Should return false when no path sums to -4");
    }
}
