package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestLRUCache {

	@Test
	void returnsMinusOneWhenKeyNotPresent() {
		LRUCache cache = new LRUCache(2);
		assertEquals(-1, cache.get(1));
	}

	@Test
	void returnsValueWhenKeyPresent() {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		assertEquals(1, cache.get(1));
	}

	@Test
	void updatesValueWhenKeyAlreadyPresent() {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(1, 2);
		assertEquals(2, cache.get(1));
	}

	@Test
	void evictsLeastRecentlyUsedWhenCapacityExceeded() {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		assertEquals(-1, cache.get(1));
		assertEquals(2, cache.get(2));
		assertEquals(3, cache.get(3));
	}

	@Test
	void movesAccessedKeyToHead() {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);
		cache.put(3, 3);
		assertEquals(1, cache.get(1));
		assertEquals(-1, cache.get(2));
		assertEquals(3, cache.get(3));
	}

	@Test
	void handlesCapacityOfOne() {
		LRUCache cache = new LRUCache(1);
		cache.put(1, 1);
		cache.put(2, 2);
		assertEquals(-1, cache.get(1));
		assertEquals(2, cache.get(2));
	}

}
