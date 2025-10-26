package com.dsa.graph.demo;

import java.util.Arrays;

public class MarkAndToys {

	public int maximumToys(int[] prices, int amountToSpend) {
		int priceLen = prices.length;
		Arrays.sort(prices);
		int toyCount = 0;
		int totalSpent = 0;
		for (int idx = 0; idx < priceLen; idx++) {
			if (totalSpent + prices[idx] <= amountToSpend) {
				totalSpent += prices[idx];
				toyCount++;
			} else {
				break;
			}
		}
		return toyCount;
	}

}
