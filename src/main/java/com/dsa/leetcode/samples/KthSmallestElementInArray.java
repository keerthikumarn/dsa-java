package com.dsa.leetcode.samples;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestElementInArray {

	/*public static void main(String[] args) {
		System.out.println(kthSmallest(new Integer[] { 12, 3, 5, 7, 19 }, 2));
		System.out.println(kthSmallestWithPQ(new Integer[] { 12, 3, 5, 7, 19 }, 2));
	}*/

	public int kthSmallest(Integer[] arr, int K) {
		Arrays.sort(arr);
		return arr[K - 1];
	}

	public int kthSmallestWithPQ(Integer[] arr, int K) {
		PriorityQueue<Integer> pQueue = new PriorityQueue<>((a, b) -> b - a);
		for (int idx = 0; idx < arr.length; idx++) {
			pQueue.offer(arr[idx]);
			if (pQueue.size() > K) {
				pQueue.poll();
			}
		}
		return pQueue.peek();
	}

}
