package com.dsa.leetcode.samples;

public class RemoveNthNodeFromList {

	public static void main(String[] args) {

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummyNode = new ListNode(0, head);
		ListNode leftNode = dummyNode;
		ListNode rightNode = head;

		while (n > 0) {
			rightNode = rightNode.next;
			n--;
		}
		while (rightNode != null) {
			leftNode = leftNode.next;
			rightNode = rightNode.next;
		}
		leftNode.next = leftNode.next.next;
		return dummyNode.next;
	}

}
