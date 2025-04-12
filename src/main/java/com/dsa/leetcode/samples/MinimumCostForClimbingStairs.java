package com.dsa.leetcode.samples;

public class MinimumCostForClimbingStairs {
	
	public int minCostClimbingStairs(int[] cost) {
		if (cost.length == 0) {
			return 0;
		}
		if (cost.length == 1) {
			return cost[0];
		}
		
		for (int idx = cost.length - 3; idx >= 0; idx--) {
			cost[idx] += Math.min(cost[idx + 1], cost[idx + 2]);
		}
		return Math.min(cost[0], cost[1]);
	}
}
