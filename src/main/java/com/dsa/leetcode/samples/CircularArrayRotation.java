package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.List;

public class CircularArrayRotation {

	public List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
		int arrSize = a.size();
		k = k % arrSize;
		List<Integer> result = new ArrayList<>();
		for (int query : queries) {
			int newIndex = (query - k + arrSize) % arrSize;
			result.add(a.get(newIndex));
		}
		return result;
	}

}
