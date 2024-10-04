package com.dsa.leetcode.samples;

import java.util.PriorityQueue;

public class KthLargestInStream {

	private static PriorityQueue<Integer> minHeap;
	private static int k;

	public static void main(String[] args) {

	}

	public KthLargestInStream(int k, int[] nums) {
		this.k = k;
		minHeap = new PriorityQueue<>();
		for (int num : nums) {
			minHeap.offer(num);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
	}

	private static int add(int val) {
		minHeap.offer(val);
		if(minHeap.size() > k) {
			minHeap.poll();
		}
		return minHeap.peek();
	}

}
