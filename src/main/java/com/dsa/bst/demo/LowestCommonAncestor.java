package com.dsa.bst.demo;

public class LowestCommonAncestor {

	Node root;

	public static void main(String[] args) {
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		// Function calls
		int n1 = 10, n2 = 14;
		Node t = tree.lowestCommonAncestor(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);

		n1 = 14;
		n2 = 8;
		t = tree.lowestCommonAncestor(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);

		n1 = 10;
		n2 = 22;
		t = tree.lowestCommonAncestor(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);
	}

	public Node lowestCommonAncestor(Node node, int n1, int n2) {
		if (node == null) {
			return null;
		}

		if (node.key > n1 && node.key > n2) {
			return lowestCommonAncestor(node.left, n1, n2);
		}
		if (node.key < n1 && node.key < n2) {
			return lowestCommonAncestor(node.right, n1, n2);
		}
		return node;
	}

}
