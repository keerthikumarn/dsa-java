package com.dsa.leetcode.samples;

public class SortedArrayToBST {

	public static void main(String[] args) {
		TreeNode node = sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });
	}

	private static TreeNode sortedArrayToBST(int[] nums) {
		// 0 == left, nums.length-1 == right
		return convertToBST(nums, 0, nums.length - 1);
	}

	private static TreeNode convertToBST(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		int midNum = (left + right) / 2;
		TreeNode rootNode = new TreeNode(nums[midNum]);
		rootNode.left = convertToBST(nums, left, midNum - 1);
		rootNode.right = convertToBST(nums, midNum + 1, right);
		return rootNode;
	}

}
