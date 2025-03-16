package com.dsa.leetcode.samples;

public class BullsAndCows {

	private static final String A = "A";
	private static final String B = "B";

	public String getHint(String secret, String guess) {

		int cows = 0;
		int bulls = 0;
		int[] guessCount = new int[10];
		int[] secretCount = new int[10];

		for (int idx = 0; idx < secret.length(); idx++) {
			if (secret.charAt(idx) == guess.charAt(idx)) {
				bulls++;
			} else {
				guessCount[guess.charAt(idx) - '0']++;
				secretCount[secret.charAt(idx) - '0']++;
			}
		}
		for (int idx = 0; idx < 10; idx++) {
			cows += Math.min(secretCount[idx], guessCount[idx]);
		}

		return bulls + A + cows + B;
	}
}
