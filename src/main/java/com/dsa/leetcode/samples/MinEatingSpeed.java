package com.dsa.leetcode.samples;

public class MinEatingSpeed {

	public static void main(String[] args) {
		System.out.println(minEatingSpeed(new int[] { 1, 4, 3, 2 }, 9));
	}

	/* Brute force approach */
	private static int minEatingSpeed(int[] piles, int h) {
		int eatingSpeed = 0;
		while (true) {
			long totalTimeTaken = 0;
			for (int pile : piles) {
				totalTimeTaken = totalTimeTaken + (int) Math.ceil((double) pile / eatingSpeed);
			}
			if (totalTimeTaken <= h) {
				return eatingSpeed;
			}
			eatingSpeed++;
		}
	}

}
