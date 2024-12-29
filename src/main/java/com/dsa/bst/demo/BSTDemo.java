package com.dsa.bst.demo;

public class BSTDemo {

	private Node root;

	public BSTDemo() {
		root = null;
	}

	public void insert(int key) {
		root = insertKey(root, key);
	}

	private Node insertKey(Node root, int key) {
		if (root == null) {
			return new Node(key);
		}
		if (key < root.key) {
			root.left = insertKey(root.left, key);
		} else if (key > root.key) {
			root.right = insertKey(root.right, key);
		}
		return root;
	}

	public void inorder() {
		inOrderTraversal(root);
	}

	private void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.key + " -> ");
			inOrderTraversal(root.right);
		}
	}

	public void deleteKey(int key) {
		root = delete(root, key);
	}

	private Node delete(Node root, int key) {
		if (root == null) {
			return root;
		}

		// Find the node to be deleted
		if (key < root.key) {
			root.left = delete(root.left, key);
		} else if (key > root.key) {
			root.right = delete(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			// root.key = minValue(root.right);
			// Delete the inorder successor
			root.right = delete(root.right, root.key);
		}
		return root;
	}

	public static void main(String[] args) {
		BSTDemo tree = new BSTDemo();

		tree.insert(8);
		tree.insert(3);
		tree.insert(1);
		tree.insert(6);
		tree.insert(7);
		tree.insert(10);
		tree.insert(14);
		tree.insert(4);

		System.out.print("Inorder traversal: ");
		tree.inorder();

		System.out.println("\n\nAfter deleting 10");
		tree.deleteKey(10);
		System.out.print("Inorder traversal: ");
		tree.inorder();
	}

}
