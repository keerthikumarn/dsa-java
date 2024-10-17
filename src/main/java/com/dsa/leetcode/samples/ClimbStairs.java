package com.dsa.leetcode.samples;

public class ClimbStairs {

	/*public static void main(String[] args) {
		System.out.println(climbStairs(2));
		System.out.println(climbStairs(3));
		System.out.println(climbStairs(5));
	}*/

	public int climbStairs(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int idx = 2; idx <= n; idx++) {
			dp[idx] = dp[idx - 1] + dp[idx - 2];
		}
		return dp[n];
	}

}
