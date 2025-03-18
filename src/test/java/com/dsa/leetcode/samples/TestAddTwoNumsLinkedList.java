package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAddTwoNumsLinkedList {

	private AddTwoNumsLinkedList addTwoNumsLinkedList;

	@BeforeEach
	void setUp() {
		addTwoNumsLinkedList = new AddTwoNumsLinkedList();
	}

	@Test
	void addTwoNumbersBothListsEmptyReturnsEmptyList() {
		ListNode result = addTwoNumsLinkedList.addTwoNumbers(null, null);
		assertEquals(null, result);
	}

	@Test
	void addTwoNumbersOneListEmptyReturnsOtherList() {
		ListNode l1 = new ListNode(1);
		ListNode result = addTwoNumsLinkedList.addTwoNumbers(l1, null);
		assertEquals(1, result.val);
		assertEquals(null, result.next);
	}

	@Test
	void addTwoNumbersNoCarryReturnsCorrectSum() {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		ListNode l2 = new ListNode(3);
		l2.next = new ListNode(5);
		ListNode result = addTwoNumsLinkedList.addTwoNumbers(l1, l2);
		assertEquals(5, result.val);
		assertEquals(9, result.next.val);
		assertEquals(null, result.next.next);
	}

	@Test
	void addTwoNumbersWithCarryReturnsCorrectSum() {
		ListNode l1 = new ListNode(5);
		l1.next = new ListNode(6);
		ListNode l2 = new ListNode(7);
		l2.next = new ListNode(8);
		ListNode result = addTwoNumsLinkedList.addTwoNumbers(l1, l2);
		assertEquals(2, result.val);
		assertEquals(5, result.next.val);
		assertEquals(1, result.next.next.val);
		assertEquals(null, result.next.next.next);
	}

	@Test
	void addTwoNumbersDifferentLengthsReturnsCorrectSum() {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		ListNode result = addTwoNumsLinkedList.addTwoNumbers(l1, l2);
		assertEquals(0, result.val);
		assertEquals(0, result.next.val);
		assertEquals(1, result.next.next.val);
		assertEquals(null, result.next.next.next);
	}

}
