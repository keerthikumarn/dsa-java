package com.dsa.leetcode.samples;

public class BalancedBinaryTree {

	public static void main(String[] args) {

	}

	private static boolean isBalanced(TreeNode root) {
		return depthFirstSearch(root)[0] == 1;
	}

	private static int[] depthFirstSearch(TreeNode root) {
		if (root == null) {
			return new int[] { 1, 0 };
		}
		int[] left = depthFirstSearch(root.left);
		int[] right = depthFirstSearch(root.right);
		boolean balanced = left[0] == 1 && right[0] == 1 
				&& Math.abs(left[1] - right[1]) <= 1;
		int height = 1 + Math.max(left[1], right[1]);
		return new int[] { balanced ? 1 : 0, height };
	}

}
