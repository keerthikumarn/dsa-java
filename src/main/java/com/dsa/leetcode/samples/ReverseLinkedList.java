package com.dsa.leetcode.samples;

public class ReverseLinkedList {

	public static void main(String[] args) {

	}

	private static ListNode reverseList(ListNode head) {
		ListNode currNode = head;
		ListNode prevNode = null;
		while (currNode != null) {
			ListNode nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		return prevNode;
	}

}
