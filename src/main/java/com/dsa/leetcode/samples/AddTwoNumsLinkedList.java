package com.dsa.leetcode.samples;

public class AddTwoNumsLinkedList {

	public ListNode addTwoNumbers(ListNode leftNode1, ListNode leftNode2) {
		ListNode dummyHead = new ListNode(0);
		ListNode currNode = dummyHead;
		int carry = 0;
		while (leftNode1 != null || leftNode2 != null) {
			int x = (leftNode1 != null) ? leftNode1.val : 0;
			int y = (leftNode2 != null) ? leftNode2.val : 0;
			int sum = x + y + carry;
			carry = sum / 10;
			currNode.next = new ListNode(sum % 10);
			currNode = currNode.next;

			if (leftNode1 != null)
				leftNode1 = leftNode1.next;
			if (leftNode2 != null)
				leftNode2 = leftNode2.next;
		}
		if (carry > 0) {
			currNode.next = new ListNode(carry);
		}
		return dummyHead.next;
	}

}
