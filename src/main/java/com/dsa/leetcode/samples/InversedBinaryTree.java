package com.dsa.leetcode.samples;

public class InversedBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode tempNode = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(tempNode);
		return root;
	}

}
