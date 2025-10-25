package com.dsa.leetcode.samples;

import java.util.HashMap;
import java.util.Map;

public class HashTableIceCreamParlor {

	public void solve(int[] arr, int money) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int len = arr.length;
		for (int idx = 1; idx <= len; idx++) {
			map.put(arr[idx - 1], idx);
		}
		for (int idx = 1; idx <= len; idx++) {
			if (map.containsKey(arr[idx - 1]) 
					&& map.containsKey(Math.abs(money - arr[idx - 1]))) {
				System.out.println(idx + " " + map.get(Math.abs(money - arr[idx - 1])));
				break;
			}
		}
	}

}
