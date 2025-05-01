package com.dsa.leetcode.samples;

public class LinkedListIntersection {
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode aNode = headA;
		ListNode bNode = headB;
		
		while (aNode != bNode) {
			aNode = (aNode == null) ? headB : aNode.next;
			bNode = (bNode == null) ? headA : bNode.next;
		}
		return aNode;
	}

}
