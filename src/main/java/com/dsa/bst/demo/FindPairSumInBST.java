package com.dsa.bst.demo;

import java.util.HashSet;

class FindPairSumInBST {

	private static boolean dfs(Node root, HashSet<Integer> set, int sum) {
		if (root == null) {
			return false;
		}

		if (set.contains(sum - root.key)) {
			return true;
		}
		set.add(root.key);
		return dfs(root.left, set, sum) || dfs(root.right, set, sum);
	}

	private static boolean findTarget(Node root, int sum) {
		HashSet<Integer> set = new HashSet<>();
		return dfs(root, set, sum);
	}

	public static void main(String[] args) {
		// Constructing the following BST:
		// 7
		// / \
		// 3 8
		// / \ \
		// 2 4 9
		Node root = new Node(7);
		root.left = new Node(3);
		root.right = new Node(8);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.right.right = new Node(9);
		int sum = 12;
		if (findTarget(root, sum)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
}
