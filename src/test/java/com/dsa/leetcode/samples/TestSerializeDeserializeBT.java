package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSerializeDeserializeBT {

	private final SerializeDeserializeBT codec = new SerializeDeserializeBT();

	private TreeNode buildTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		return root;
	}

	private boolean areEqual(TreeNode a, TreeNode b) {
		if (a == null && b == null)
			return true;
		if (a == null || b == null)
			return false;
		return a.val == b.val && areEqual(a.left, b.left) && areEqual(a.right, b.right);
	}

	@Test
	public void testSerializeDeserialize_NullTree() {
		TreeNode root = null;
		String serialized = codec.serialize(root);
		assertEquals("null,", serialized);
		TreeNode deserialized = codec.deserialize(serialized);
		assertNull(deserialized);
	}

	@Test
	public void testSerializeDeserialize_SingleNode() {
		TreeNode root = new TreeNode(10);
		String serialized = codec.serialize(root);
		assertEquals("10,null,null,", serialized);
		TreeNode deserialized = codec.deserialize(serialized);
		assertTrue(areEqual(root, deserialized));
	}

	@Test
	public void testSerializeDeserialize_ComplexTree() {
		TreeNode root = buildTree();
		String serialized = codec.serialize(root);
		TreeNode deserialized = codec.deserialize(serialized);
		assertTrue(areEqual(root, deserialized));
	}

	@Test
	public void testSerializeDeserialize_UnbalancedTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		String serialized = codec.serialize(root);
		TreeNode deserialized = codec.deserialize(serialized);
		assertTrue(areEqual(root, deserialized));
	}

}
