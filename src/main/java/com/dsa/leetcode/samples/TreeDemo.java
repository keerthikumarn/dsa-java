package com.dsa.leetcode.samples;

public class TreeDemo {

	private static TreeNode rootNode;

	public static void main(String[] args) {
		TreeDemo.insert(11);
		TreeDemo.insert(20);
		TreeDemo.insert(3);
		TreeDemo.insert(42);
		TreeDemo.insert(54);
		TreeDemo.insert(16);
		TreeDemo.insert(32);
		TreeDemo.insert(9);
		TreeDemo.insert(4);
		TreeDemo.insert(10);
		TreeDemo.preOrder(rootNode);
		TreeDemo.inOrder(rootNode);
		TreeDemo.postOrder(rootNode);
		System.out.println(search(rootNode, 10) != null
                ? "Found"
                : "Not Found");
	}

	private static void insert(int data) {
		TreeNode tempNode = new TreeNode();
		tempNode.val = data;
		if (rootNode == null) {
			rootNode = tempNode;
		} else {
			TreeNode current = rootNode;
			TreeNode parent = null;

			while (true) {
				parent = current;
				if (data < parent.val) {
					current = current.left;
					if (current == null) {
						parent.left = tempNode;
						return;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = tempNode;
						return;
					}
				}
			}
		}
	}

	private static TreeNode search(TreeNode rootNode, int data) {
		if (rootNode == null || rootNode.val == data) {
			return rootNode;
		}
		if (rootNode.val < data) {
			return search(rootNode.right, data);
		}
		return search(rootNode.left, data);
	}

	private static void preOrder(TreeNode rootNode) {
		if (rootNode != null) {
			System.out.println("Data : " + rootNode.val + " ");
			preOrder(rootNode.left);
			preOrder(rootNode.right);
		}
	}

	private static void inOrder(TreeNode rootNode) {
		if (rootNode != null) {
			inOrder(rootNode.left);
			System.out.println("Data : " + rootNode.val + " ");
			inOrder(rootNode.right);
		}
	}

	private static void postOrder(TreeNode rootNode) {
		if (rootNode != null) {
			postOrder(rootNode.left);
			postOrder(rootNode.right);
			System.out.println("Data : " + rootNode.val + " ");
		}
	}

}
