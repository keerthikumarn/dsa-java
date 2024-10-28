package com.dsa.leetcode.samples;

public class JumpingOnClouds {

	public static void main(String[] args) {

	}

	private static int jumpingOnClouds(int[] c, int k) {
		int index = 0;
		int len = c.length;
		int energyLevel = 100;
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
