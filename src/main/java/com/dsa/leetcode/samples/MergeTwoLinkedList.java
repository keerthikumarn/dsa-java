package com.dsa.leetcode.samples;

public class MergeTwoLinkedList {

	public static void main(String[] args) {

	}

	private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummyNode = new ListNode(0);
		ListNode node = dummyNode;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				node.next = list1;
				list1= list1.next;
			} else {
				node.next = list2;
				list2= list2.next;
			}
			node = node.next;
		}
		if (list1 != null) {
			node.next = list1;
		} else {
			node.next = list2;
		}
		return dummyNode.next;
	}

	private static ListNode mergeTwoListsRecursively(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		if (list1.val < list2.val) {
			list1.next = mergeTwoListsRecursively(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoListsRecursively(list2.next, list1);
			return list2;
		}
	}

}
