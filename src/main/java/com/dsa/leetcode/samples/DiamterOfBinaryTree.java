package com.dsa.leetcode.samples;

public class DiamterOfBinaryTree {
	public static void main(String[] args) {

	}

	private int diameter = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		calculateHeightOfNode(root);
		return diameter;
	}

	private int calculateHeightOfNode(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int leftHeight = calculateHeightOfNode(node.left);
		int rightHeight = calculateHeightOfNode(node.right);
		diameter = Math.max(diameter, leftHeight + rightHeight);
		return Math.max(leftHeight, rightHeight) + 1;
	}

}
