package com.dsa.leetcode.samples;

import java.util.ArrayDeque;
import java.util.Deque;

public class PrintAllPathsFromRootToLeafNodes {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.left = new TreeNode(8);
		root.right.right.right = new TreeNode(9);
		printRootToLeafPaths(root);
	}

	private static boolean isLeaf(TreeNode node) {
		return (node.left == null && node.right == null);
	}

	private static void printRootToLeafPaths(TreeNode node, Deque<Integer> path) {
		if (node == null) {
			return;
		}
		// include the current node to the path
		path.addLast(node.val);
		// if a leaf node is found, print the path
		if (isLeaf(node)) {
			System.out.println(path);
		}

		// recur for the left and right subtree
		printRootToLeafPaths(node.left, path);
		printRootToLeafPaths(node.right, path);

		// backtrack: remove the current node after the left, and right subtree are done
		path.removeLast();
	}

	private static void printRootToLeafPaths(TreeNode node) {
		Deque<Integer> path = new ArrayDeque<>();
		printRootToLeafPaths(node, path);
	}

}
