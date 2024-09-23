package com.dsa.leetcode.samples;

public class ReversingLinkedList {

	public static void main(String[] args) {

	}

	private static ListNode reverseList(ListNode head) {
		ListNode currNode = head;
		ListNode prevNode = null;
		ListNode nextNode = null;
		while (currNode != null) {
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		return prevNode;
	}
}
