package com.dsa.bst.demo;

public class KthLargestElementInBST {
	
	private static int result = -1;
	private static int count = 0;
	
	public static int kthLargest(Node root, int k) {
		System.out.println("Invoking the kthLargest..");
		reverseInOrder(root, k);
		return result;
	}

	private static void reverseInOrder(Node root, int k) {
		if(root == null || count >= k) {
			return;
		}
		reverseInOrder(root.right, k);
		count++;
		if(count == k) {
			result = root.key;
			return;
		}
		reverseInOrder(root.left, k);
	}
	
	public static void main(String[] args) {
		Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);
        int k = 3;
        System.out.println("The " + k + "rd largest element is " + kthLargest(root, k));
    }
}
