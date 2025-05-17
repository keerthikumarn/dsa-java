package com.dsa.leetcode.samples;

public class JumpingOnClouds {

	public int jumpingOnClouds(int[] c, int k) {
		int energyLevel = 100;
		int len = c.length;
		int index = 0;
		do {
			index = (index + k) % len;
			energyLevel--;
			if (c[index] == 1) {
				energyLevel -= 2;
			}
		} while (index != 0);
		return energyLevel;
	}
}
