package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestLinkedListCycle {

	private LinkedListCycle cycleChecker;
	
	@BeforeEach
	void setUp() {
		cycleChecker = new LinkedListCycle();
	}

    @Test
    public void testHasCycleTrue() {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        assertTrue(cycleChecker.hasCycle(node1));
    }

    @Test
    public void testHasCycleFalse() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);

        node1.next = node2;
        node2.next = null;

        assertFalse(cycleChecker.hasCycle(node1));
    }

    @Test
    public void testHasCycleSingleNodeWithCycle() {
        ListNode node1 = new ListNode(1);
        node1.next = node1;  // Self-loop

        assertTrue(cycleChecker.hasCycle(node1));
    }

    @Test
    public void testHasCycleSingleNodeNoCycle() {
        ListNode node1 = new ListNode(1);
        assertFalse(cycleChecker.hasCycle(node1));
    }

    @Test
    public void testHasCycleEmptyList() {
        assertFalse(cycleChecker.hasCycle(null));
    }

    @Test
    public void testHasCycleLongListNoCycle() {
        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i = 2; i <= 1000; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }
        assertFalse(cycleChecker.hasCycle(head));
    }

    @Test
    public void testHasCycleLongListWithCycleAtEnd() {
        ListNode head = new ListNode(1);
        ListNode current = head;
        ListNode cycleEntry = null;

        for (int i = 2; i <= 1000; i++) {
            current.next = new ListNode(i);
            current = current.next;
            if (i == 500) {
                cycleEntry = current;  // Store entry point to create cycle
            }
        }

        current.next = cycleEntry;  // Create cycle
        assertTrue(cycleChecker.hasCycle(head));
    }

}
