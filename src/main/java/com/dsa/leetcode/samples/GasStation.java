package com.dsa.leetcode.samples;

public class GasStation {

	/*public static void main(String[] args) {
		System.out.println(canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5, 1, 2 }));
	}*/

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int totalGas = 0;
		int currGas = 0;
		int totalCost = 0;
		int totalTank = 0;
		int startIdx = 0;

		// compute total gas and total cost
		for (int idx = 0; idx < gas.length; idx++) {
			totalGas = totalGas + gas[idx];
			totalCost = totalCost + cost[idx];
			totalTank = totalTank + gas[idx] - cost[idx];
		}
		if (totalGas < totalCost) {
			return -1;
		}
		// compute the startIndex
		for (int idx = 0; idx < gas.length; idx++) {
			currGas = currGas + gas[idx] - cost[idx];
			if (currGas < 0) {
				startIdx = idx + 1;
				currGas = 0;
			}
		}
		return startIdx;
	}

}
