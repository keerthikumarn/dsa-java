package com.dsa.slidingiwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitsInBasket {

	public static void main(String[] args) {

	}

	private static int totalFruit(int[] tree) {
		Map<Integer, Integer> fruitsMap = new HashMap<Integer, Integer>();
		int start = 0;
		int maxFruits = 0;
		int treeLen = tree.length;
		for (int end = 0; end < treeLen; end++) {
			fruitsMap.put(tree[end], fruitsMap.getOrDefault(tree[end], 0) + 1);
			while(fruitsMap.size() > 2) {
				fruitsMap.put(tree[start], fruitsMap.get(tree[start]) - 1);
				if (fruitsMap.get(tree[start]) == 0) {
					fruitsMap.remove(tree[start]);
                }
                start++; 
			}
			maxFruits = Math.max(maxFruits, end - start + 1);
		}
		return maxFruits;
	}

}
