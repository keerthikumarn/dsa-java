package com.dsa.leetcode.samples;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class BuySellStocks {

	/*public static void main(String[] args) {
		int[] prices1 = new int[] { 7, 1, 5, 3, 6, 4 };
		int[] prices2 = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(maxProfit(prices1));
		System.out.println(maxProfit(prices2));
	}*/

	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		for (int pIndex = 1; pIndex < prices.length; pIndex++) {
			if (prices[pIndex] > prices[pIndex - 1]) {
				System.out.println("current day Price = " + prices[pIndex]);
				System.out.println("previous day Price = " + prices[pIndex - 1]);
				maxProfit = maxProfit + prices[pIndex] - prices[pIndex - 1];
			}
		}
		return maxProfit;
	}

}
