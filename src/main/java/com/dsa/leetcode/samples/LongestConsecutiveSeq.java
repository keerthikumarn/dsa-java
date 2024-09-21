package com.dsa.leetcode.samples;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {

	public static void main(String[] args) {
		int[] num = new int[] { 2, 20, 4, 10, 3, 4, 5 };
		System.out.println(longestConsecutive(num));
	}

	private static int longestConsecutive(int[] nums) {
		Set<Integer> numSet = new HashSet<>();
		for (int num : nums) {
			numSet.add(num);
		}
		int longestStreak = 0;
		for (int num : nums) {
			if (!numSet.contains(num - 1)) {
				int currentNum = num;
				int currentStreak = 1;
				while (numSet.contains(currentNum + 1)) {
					currentNum++;
					currentStreak++;
				}
				longestStreak = Math.max(longestStreak, currentStreak);
			}
		}
		return longestStreak;
	}

}
