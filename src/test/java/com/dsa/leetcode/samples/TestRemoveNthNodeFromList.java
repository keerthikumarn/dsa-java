package com.dsa.leetcode.samples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRemoveNthNodeFromList {

	private RemoveNthNodeFromList obj;

	@BeforeEach
	void setUp() {
		obj = new RemoveNthNodeFromList();
	}

	@Test
	void testRemoveNthFromEnd() {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		int n = 2;
		ListNode result = obj.removeNthFromEnd(head, n);
		assertEquals(1, result.val);
		assertEquals(2, result.next.val);
		assertEquals(3, result.next.next.val);
		assertEquals(5, result.next.next.next.val);
	}

	// test case for negative case
	void testRemoveNthFromEndNegative() {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		int n = 2;
		ListNode result = obj.removeNthFromEnd(head, n);
		assertEquals(1, result.val);
		assertEquals(2, result.next.val);
		assertEquals(3, result.next.next.val);
		assertEquals(4, result.next.next.next.val);
	}

}
