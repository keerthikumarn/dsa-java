package com.dsa.leetcode.samples;

public class PathSumOfBT {

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}
		targetSum = targetSum - root.val;
		if (root.left == null && root.right == null) {
			return 0 == targetSum;
		}
		return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);

	}
}
