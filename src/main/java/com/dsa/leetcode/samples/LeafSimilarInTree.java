package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarInTree {

	public static void main(String[] args) {

	}

	private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return false;
		}
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		getLeafNodes(root1, list1);
		getLeafNodes(root2, list2);
		if (list1.size() != list2.size()) {
			return false;
		}
		for (int idx = 0; idx < list1.size(); idx++) {
			if (list1.get(idx) != list2.get(idx)) {
				return false;
			}
		}
		return true;
	}

	private static void getLeafNodes(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		getLeafNodes(root.left, list);
		getLeafNodes(root.right, list);
		if (root.left == null && root.right == null) {
			list.add(root.val);
		}
	}

}
