package com.dsa.leetcode.samples;

public class MaxPathSumOfBT {

	private int maxPathValue = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		treeHelper(root);
		return maxPathValue;
	}

	private int treeHelper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = Math.max(0, treeHelper(root.left));
		int right = Math.max(0, treeHelper(root.right));

		maxPathValue = Math.max(maxPathValue, root.val + left + right);

		return root.val + Math.max(left, right);
	}
}
