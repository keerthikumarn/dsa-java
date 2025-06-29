package com.dsa.leetcode.samples;

import java.util.List;

public class MaxStock {

	public long stockmax(List<Integer> prices) {
		long maxProfit = 0;
		int maxPrice = 0;
		for (int price = prices.size(); price > 0; price--) {
			if (prices.get(price - 1) > maxPrice) {
				maxPrice = prices.get(price - 1);
			} else {
				maxProfit += maxPrice - prices.get(price - 1);
			}
		}
		return maxProfit;
	}
}
