package com.dsa.leetcode.samples;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

	public static void main(String[] args) {
		int[] arr1 = { 3, 2, 1, 5, 6, 4 };
		int[] arr2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		System.out.println("VALUE : " + findKthLargest(arr1, 2));
		System.out.println("VALUE : " + findKthLargest(arr2, 4));
	}

	private static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (int num : nums) {
			heap.add(num);
			if (heap.size() > k) {
				heap.poll();
			}
		}
		return heap.peek();
	}

}
