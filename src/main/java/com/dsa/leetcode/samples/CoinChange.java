package com.dsa.leetcode.samples;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		System.out.println(coinChange(new int[] { 1, 2, 5 }, 11));
		System.out.println(coinChange(new int[] { 2 }, 3));
		System.out.println(coinChange(new int[] { 1 }, 0));
	}

	private static int coinChange(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		int dp[] = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int idx = 0; idx <= amount; idx++) {
			for (int coin : coins) {
				if (idx - coin >= 0) {
					dp[idx] = Math.min(dp[idx], dp[idx - coin] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}

}
