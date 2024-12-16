package com.dsa.leetcode.samples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSearchInBST {
	@Test
	void testSearchBST_NodeExists() {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		SearchInBST bstSearch = new SearchInBST();
		TreeNode result = bstSearch.searchBST(root, 2);

		assertNotNull(result);
		assertEquals(2, result.val);
		assertEquals(1, result.left.val);
		assertEquals(3, result.right.val);
	}
}
