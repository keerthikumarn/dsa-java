package com.dsa.bst.demo;

public class CountBSTNodes {

	public static int getBSTCount(Node root, int low, int high) {
		if (root == null) {
			return 0;
		}
		if (root.key <= high && root.key >= low) {
			return 1 + getBSTCount(root.left, low, high) + getBSTCount(root.right, low, high);
		} else if (root.key < low) {
			return getBSTCount(root.right, low, high);
		} else {
			return getBSTCount(root.left, low, high);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(50);
        root.left.left = new Node(1);
        root.right.left = new Node(40);
        root.right.right = new Node(100);
        int low = 5;
        int high = 45;
        getBSTCount(root, low, high);
	}

}
