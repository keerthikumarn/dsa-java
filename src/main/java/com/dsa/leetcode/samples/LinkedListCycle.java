package com.dsa.leetcode.samples;

public class LinkedListCycle {

	public static void main(String[] args) {

	}

	private static boolean hasCycle(ListNode head) {
		/* 2 pointer approach */
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if (slowPtr == fastPtr) {
				return true;
			}
		}
		return false;
	}

}
