package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrderWithoutRecursion {

	public List<Integer> preOrderWithoutRecursion(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<Integer> treeNodeList = new ArrayList<>();
		Stack<TreeNode> treeStack = new Stack<>();
		treeStack.push(root);
		while (!treeStack.isEmpty()) {
			TreeNode node = treeStack.pop();
			treeNodeList.add(node.val);
			if (node.right != null) {
				treeStack.push(node.right);
			}
			if (node.left != null) {
				treeStack.push(node.left);
			}
		}
		return treeNodeList;
	}

}
