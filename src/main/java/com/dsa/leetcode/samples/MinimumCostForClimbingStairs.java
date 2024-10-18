package com.dsa.leetcode.samples;

public class MinimumCostForClimbingStairs {
	public int minCostClimbingStairs(int[] cost) {
		for (int idx = cost.length - 3; idx >= 0; idx--) {
			cost[idx] += Math.min(cost[idx + 1], cost[idx + 2]);
		}
		return Math.min(cost[0], cost[1]);
	}
}
