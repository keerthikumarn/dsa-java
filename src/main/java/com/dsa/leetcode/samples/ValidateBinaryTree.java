package com.dsa.leetcode.samples;

public class ValidateBinaryTree {

	public boolean isValidBST(TreeNode root) {
		return dfs(root, null, null);
	}

	private boolean dfs(TreeNode node, Integer min, Integer max) {
		if (node == null) {
			return true;
		}
		int nodeVal = node.val;
		if (min != null && nodeVal <= min) {
			return false;
		}
		if (max != null && nodeVal >= max) {
			return false;
		}
		return dfs(node.left, min, nodeVal) && dfs(node.right, nodeVal, max);
	}

}
