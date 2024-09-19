package com.dsa.leetcode.samples;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MostFrequentElementsInArray {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 3, 3, 3 };
		System.out.println(topKFrequent(nums, 1));
	}

	private static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> heap = new HashMap<>();
		for (int num : nums) {
			heap.put(num, heap.getOrDefault(num, 0) + 1);
		}
		// PriorityQueue to store the k most frequent elements
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		// Add all elements from the heap to the max heap
		for (Map.Entry<Integer, Integer> entry : heap.entrySet()) {
			maxHeap.offer(entry);
		}
		int[] resultArr = new int[k];
		for (int idx = 0; idx < k; idx++) {
			resultArr[idx] = maxHeap.poll().getKey();
		}
		return resultArr;
	}

}
