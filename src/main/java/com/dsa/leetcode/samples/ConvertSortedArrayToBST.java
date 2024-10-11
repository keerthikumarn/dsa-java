package com.dsa.leetcode.samples;

public class ConvertSortedArrayToBST {

	public static void main(String[] args) {

	}

	private static TreeNode sortedArrayToBST(int[] num) {
		return makeTree(num, 0, num.length - 1);
	}

	private static TreeNode makeTree(int[] num, int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		TreeNode midNode = new TreeNode(mid);
		midNode.left = makeTree(num, left, mid - 1);
		midNode.right = makeTree(num, mid + 1, right);
		return midNode;
	}

}
