package com.dsa.leetcode.samples;

import java.util.PriorityQueue;

public class LastStoneWeight {

	/*public static void main(String[] args) {
		System.out.println(lastStoneWeight(new int[] { 2, 3, 6, 2, 4 }));
	}*/

	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int stone : stones) {
			queue.offer(-stone);
		}
		while (queue.size() > 1) {
			int firstNum = queue.poll();
			int secondNum = queue.poll();
			if (secondNum > firstNum) {
				queue.offer(firstNum - secondNum);
			}
		}
		queue.offer(0);
		return Math.abs(queue.peek());
	}

}
