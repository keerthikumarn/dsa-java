package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestLinkedListMerge {

	private LinkedListMerge merger;

	@BeforeEach
	void setUp() {
		merger = new LinkedListMerge();
	}

	private ListNode createList(int[] values) {
	    ListNode dummy = new ListNode(-1);
	    ListNode current = dummy;
	    for (int val : values) {
	        current.next = new ListNode(val);
	        current = current.next;
	    }
	    return dummy.next;
	}

	private int[] toArray(ListNode head) {
		if (head == null) {
			return new int[0];
		}
		List<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		return list.stream().mapToInt(i -> i).toArray();
	}

	@Test
	public void testMergeTwoListsNormalCase() {
		ListNode l1 = createList(new int[] { 1, 3, 5 });
		ListNode l2 = createList(new int[] { 2, 4, 6 });
		ListNode result = merger.mergeTwoLists(l1, l2);
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, toArray(result));
	}

	@Test
	public void testMergeTwoListsOneEmpty() {
		ListNode l1 = createList(new int[] {});
		ListNode l2 = createList(new int[] { 1, 2, 3 });
		ListNode result = merger.mergeTwoLists(l1, l2);
		assertArrayEquals(new int[] { 1, 2, 3 }, toArray(result));
	}

	@Test
	public void testMergeTwoListsBothEmpty() {
		ListNode l1 = createList(new int[] {});
		ListNode l2 = createList(new int[] {});
		ListNode result = merger.mergeTwoLists(l1, l2);
		assertNull(result);
	}

	@Test
	public void testMergeTwoListsSameValues() {
		ListNode l1 = createList(new int[] { 1, 1, 1 });
		ListNode l2 = createList(new int[] { 1, 1 });
		ListNode result = merger.mergeTwoLists(l1, l2);
		assertArrayEquals(new int[] { 1, 1, 1, 1, 1 }, toArray(result));
	}

}
