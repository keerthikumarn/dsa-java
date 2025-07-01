package com.dsa.leetcode.samples;

import java.util.Collections;
import java.util.List;

public class MinMaxSum {

	public void miniMaxSum(List<Integer> arr) {
		long totalSum = 0;
		for (int num : arr) {
			totalSum += num;
		}
		long minNumber = Collections.min(arr);
		long maxNumber = Collections.max(arr);
		long minSum = totalSum - maxNumber;
		long maxSum = totalSum - minNumber;
		System.out.println(minSum + " " + maxSum);
	}
}
