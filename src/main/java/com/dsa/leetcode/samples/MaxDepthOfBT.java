package com.dsa.leetcode.samples;

public class MaxDepthOfBT {

	public static void main(String[] args) {

	}

	private static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
