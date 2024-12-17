package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;


public class TopViewOfBT {

	static class Pair {
		TreeNode node;
		int head;

		Pair(TreeNode node, int head) {
			this.node = node;
			this.head = head;
		}
	}

	public static List<Integer> topView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		Map<Integer, Integer> topNodes = new TreeMap<>();
		Queue<Pair> queue = new LinkedList<Pair>();

		queue.add(new Pair(root, 0));

		while (!queue.isEmpty()) {
			Pair temp = queue.poll();
			int head = temp.head;
			TreeNode node = temp.node;

			// If this horizontal distance is seen for the first time, store the node
			if (!topNodes.containsKey(head)) {
				topNodes.put(head, node.val);
			}

			// Add left and right children to the queue with updated horizontal distances
			if (node.left != null) {
				queue.add(new Pair(node.left, head - 1));
			}
			if (node.right != null) {
				queue.add(new Pair(node.right, head + 1));
			}
		}
		for (Map.Entry<Integer, Integer> entry : topNodes.entrySet()) {
			result.add(entry.getValue());
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> topViewResult = topView(root);
        System.out.print("Top View: ");
        for (int value : topViewResult) {
            System.out.print(value + " ");
        }
	}

}
