package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.List;

public class RightViewOfBinaryTree {

	public static void main(String[] args) {

	}

	private static List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		rightViewOfBT(root, 0, list);
		return list;
	}

	private static void rightViewOfBT(TreeNode root, int level, List<Integer> list) {
		if (root == null) {
			return;
		}
		if (list.size() == level) {
			list.add(root.val);
		}
		rightViewOfBT(root.right, level + 1, list);
		rightViewOfBT(root.left, level + 1, list);
	}

}
