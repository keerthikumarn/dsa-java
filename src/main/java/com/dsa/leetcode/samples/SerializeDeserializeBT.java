package com.dsa.leetcode.samples;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBT {

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serializeHelper(root, sb);
		return sb.toString();
	}

	private void serializeHelper(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append("null,");
			return;
		}

		sb.append(node.val).append(",");
		serializeHelper(node.left, sb);
		serializeHelper(node.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] nodes = data.split(",");
		Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
		return deserializeHelper(queue);
	}

	private TreeNode deserializeHelper(Queue<String> queue) {
		if (queue.isEmpty())
			return null;

		String val = queue.poll();
		if (val.equals("null"))
			return null;

		TreeNode node = new TreeNode(Integer.parseInt(val));
		node.left = deserializeHelper(queue);
		node.right = deserializeHelper(queue);
		return node;
	}

}
