package com.dsa.leetcode.samples;

import java.util.Arrays;
import java.util.List;

public class CompareTriplets {

	public List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		int aliceScore = 0;
		int bobScore = 0;
		for (int idx = 0; idx < 3; idx++) {
			if (a.get(idx) > b.get(idx)) {
				aliceScore++;
			} else if (a.get(idx) < b.get(idx)) {
				bobScore++;
			}
		}
		return Arrays.asList(aliceScore, bobScore);
	}
	
}
