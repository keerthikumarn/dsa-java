package com.dsa.leetcode.samples;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BTLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		Deque<TreeNode> dq = new ArrayDeque<>();
		if (root != null) {
			dq.add(root);
		}

		while (!dq.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0, len = dq.size(); i < len; i++) {
                TreeNode node = dq.poll();
                list.add(node.val);
                if (node.left != null) {
                    dq.add(node.left);
                }
                if (node.right != null) {
                    dq.add(node.right);
                }
            }
            result.add(list);
		}
		return result;
	}

}
