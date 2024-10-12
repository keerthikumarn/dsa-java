package com.dsa.leetcode.samples;

public class InversedBinaryTree {

	public static void main(String[] args) {

	}

	private static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode tempNode = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(tempNode);
		return root;
	}

}
