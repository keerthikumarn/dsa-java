package com.dsa.leetcode.samples;

public class SortLinkedList {

	public static void main(String[] args) {

	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode mid = findMiddleElementNode(head);
		ListNode sortedLeftNode = sortList(head);
		ListNode sortedRightNode = sortList(mid);
		return merge(sortedLeftNode, sortedRightNode);
	}

	private ListNode merge(ListNode sortedLeftNode, ListNode sortedRightNode) {
		ListNode dummy = new ListNode(0);
		ListNode temp = dummy;
		while (sortedLeftNode != null && sortedRightNode != null) {
			if (sortedLeftNode.val < sortedRightNode.val) {
				temp.next = sortedLeftNode;
				sortedLeftNode = sortedLeftNode.next;
				temp = temp.next;
			} else {
				temp.next = sortedRightNode;
				sortedRightNode = sortedRightNode.next;
				temp = temp.next;
			}
		}
		if (sortedLeftNode != null) {
			temp.next = sortedLeftNode;
		} else {
			temp.next = sortedRightNode;
		}
		return dummy.next;
	}

	private ListNode findMiddleElementNode(ListNode head) {
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		ListNode prevNode = null;
		while (fastPtr != null && fastPtr.next != null) {
			prevNode = slowPtr;
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		if (prevNode != null) {
			prevNode.next = null;
		}

		return slowPtr;
	}

}
