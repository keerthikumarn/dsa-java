package com.dsa.leetcode.samples;

import java.util.Arrays;

public class MinEatingSpeed {

	public static void main(String[] args) {
		System.out.println(minEatingSpeed(new int[] { 1, 4, 3, 2 }, 9));
		System.out.println(minEatingSpeedBS(new int[] { 1, 4, 3, 2 }, 9));
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

	/* Binary search approach */
	private static int minEatingSpeedBS(int[] piles, int h) {
		int left = 1;
		int right = Arrays.stream(piles).max().getAsInt();
		int minEatingSpeed = right;
		while (left <= right) {
			int mid = (left + right) / 2;
			long totalTimeTaken = 0;
			for (int pile : piles) {
				totalTimeTaken = totalTimeTaken + (int) Math.ceil((double) pile / mid);
			}
			if (totalTimeTaken <= h) {
				minEatingSpeed = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return minEatingSpeed;
	}

}
