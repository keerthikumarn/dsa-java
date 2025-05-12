package com.dsa.leetcode.samples;

public class BuyAndSellCrypto {

	public int maxProfit(int[] stockPrices) {
		int right = 1;
		int left = 0;
		int maxProfit = 0;
		while (right < stockPrices.length) {
			if (stockPrices[left] < stockPrices[right]) {
				maxProfit = Math.max(maxProfit, stockPrices[right] - stockPrices[left]);
			} else {
				left = right;
			}
			right++;
		}
		return maxProfit;
	}

}
