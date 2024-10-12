package com.dsa.leetcode.samples;

public class SymmetricTreeDFS {

	public static void main(String[] args) {

	}

	private static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetricDFS(root.left, root.right);
	}

	private static boolean isSymmetricDFS(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		return right.val == left.val && isSymmetricDFS(left.right, right.left)
				&& isSymmetricDFS(left.left, right.right);
	}

}
