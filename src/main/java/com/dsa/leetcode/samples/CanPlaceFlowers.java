package com.dsa.leetcode.samples;

public class CanPlaceFlowers {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count = 0;
		int len = flowerbed.length;
		for (int idx = 0; idx < len; idx++) {
			if (flowerbed[idx] == 0) {
				boolean leftEmpty = idx == 0 || flowerbed[idx - 1] == 0;
				boolean rightEmpty = idx == len - 1 || flowerbed[idx + 1] == 0;
				if (leftEmpty && rightEmpty) {
					flowerbed[idx] = 1; // Plant the flower
					count++;
					if (count >= n) {
						return true;
					}
				}
			}
		}
		return count >= n;
	}
}
