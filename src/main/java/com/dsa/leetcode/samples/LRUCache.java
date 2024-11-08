package com.dsa.leetcode.samples;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	public static void main(String[] args) {

	}

	private class Node {
		int key;
		int value;
		Node next;
		Node prev;

		Node(final int key, final int value) {
			this.key = key;
			this.value = value;
		}
	}

	private final int capacity;
	private final Map<Integer, Node> map;
	private Node head;
	private Node tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>();
		this.head = new Node(0, 0);
		this.tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		Node node = map.get(key);
		remove(node);
		addToHead(node);
		return node.value;
	}

	private void addToHead(Node node) {
		node.next = head.next;
		node.prev = head;
		head.next.prev = node;
		head.next = node;
	}

	private void remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {	 
			Node node = map.get(key);
			remove(node);
			node.value = value;
			addToHead(node); // Move to head
		} else {
			if (map.size() == capacity) {
				// Remove the least recently used item (tail's previous)
				map.remove(tail.prev.key);
				remove(tail.prev);
			}
			Node newNode = new Node(key, value);
			addToHead(newNode);
			map.put(key, newNode);
		}
	}
}
