package com.dsa.leetcode.samples;

public class BinaryTreeMirror {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		convertToMirrorOfTree(root);
		printTransformedTree(root);
	}

	private static void printTransformedTree(TreeNode root) {
		/*printing the transformed/mirrored tree using preOrder traversal*/
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		printTransformedTree(root.left);
		printTransformedTree(root.right);

	}

	private static void convertToMirrorOfTree(TreeNode root) {
		if (root == null) {
			return;
		}
		convertToMirrorOfTree(root.left);
		convertToMirrorOfTree(root.right);
		swapTree(root);
	}

	private static void swapTree(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode tempNode = root.left;
		root.left = root.right;
		root.right = tempNode;
	}
}
