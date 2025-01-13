package com.dsa.bst.demo;

public class ArrayToBST {

	public static void main(String[] args) {
		ArrayToBST obj = new ArrayToBST();
		int[] arr = { 1, 2, 3, 4 };
		Node root = obj.sortedArrayToBST(arr);
		obj.preOrder(root);
	}

	private Node sortedArrayToBSTRecursion(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		Node root = new Node(arr[mid]);
		root.left = sortedArrayToBSTRecursion(arr, start, mid - 1);
		root.right = sortedArrayToBSTRecursion(arr, mid + 1, end);
		return root;
	}

	public Node sortedArrayToBST(int[] arr) {
		return sortedArrayToBSTRecursion(arr, 0, arr.length - 1);
	}

	private void preOrder(Node root) {
		if (root == null)
			return;
		System.out.print(root.key + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

}
