package com.dsa.bst.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestArrayToBST {

	@Test
	void testSortedArrayToBSTWithValidArray() {
		ArrayToBST obj = new ArrayToBST();
		int[] arr = { 1, 2, 3, 4 };
		Node root = obj.sortedArrayToBST(arr);
		assertNotNull(root);
		assertEquals(2, root.key);
		assertEquals(1, root.left.key);
		assertEquals(3, root.right.key);
	}

	@Test
	void testSortedArrayToBSTWithEmptyArray() {
		ArrayToBST obj = new ArrayToBST();
		int[] arr = {};
		Node root = obj.sortedArrayToBST(arr);
		assertNull(root);
	}
	
	@Test
    void testSortedArrayToBSTSingleElementArray() {
        ArrayToBST obj = new ArrayToBST();
        int[] arr = {5};
        Node root = obj.sortedArrayToBST(arr);
        assertNotNull(root);
        assertEquals(5, root.key);
        assertNull(root.left);
        assertNull(root.right);
    }


}
