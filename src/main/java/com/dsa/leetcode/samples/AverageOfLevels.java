package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {

	public static void main(String[] args) {

	}

	private static List<Double> averageOfLevels(TreeNode root) {
		List<Double> avgs = new ArrayList<>();
		if (root == null) {
			return avgs;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int currElementsCount = queue.size();
			double sum = 0;
			for (int idx = 0; idx < currElementsCount; idx++) {
				TreeNode currNode = queue.poll();
				if (currNode.right != null) {
					queue.add(currNode.right);
				}
				if (currNode.left != null) {
					queue.add(currNode.left);
				}
				sum = sum + currNode.val;
			}
			sum = sum / currElementsCount;
			avgs.add(sum);
		}
		return avgs;
	}

}
