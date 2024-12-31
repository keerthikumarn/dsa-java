package com.dsa.bst.demo;

public class CheckIfTreeIsBST {

	Node root;

	public CheckIfTreeIsBST() {
		this.root = null;
	}

	public boolean isBSTOrNot() {
		return isBSTOrNot(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBSTOrNot(Node root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}
		if (root.key >= minValue && root.key <= maxValue && isBSTOrNot(root.left, minValue, root.key)
				&& isBSTOrNot(root.right, root.key, maxValue)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		CheckIfTreeIsBST bt = new CheckIfTreeIsBST();
		bt.root = new Node(100);
		bt.root.left = new Node(90);
		bt.root.right = new Node(110);
		bt.root.left.left = new Node(80);
		bt.root.left.right = new Node(95);
		System.out.println(bt.isBSTOrNot());
	}

}
