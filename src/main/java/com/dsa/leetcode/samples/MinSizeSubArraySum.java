package com.dsa.leetcode.samples;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinSizeSubArraySum {

	public static void main(String[] args) {
		int[] numArr1 = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen2(7, numArr1));
	}

	private static int minSubArrayLen1(int target, int[] nums) {
		int len = nums.length;
		if (len <= 0) {
			return -1;
		}
		int totalSum = 0;
		int minLen = len + 1;
		for (int start = 0, end = 0; end < len; end++) {
			totalSum = totalSum + nums[end];
			while (start < len && totalSum >= target) {
				minLen = Math.min(minLen, end - start + 1);
				totalSum = totalSum - nums[start++];
			}
		}
		return minLen <= len ? minLen : 0;
	}

	private static int minSubArrayLen2(int target, int[] nums) {
		int len = nums.length;
		int minElementsLen = Integer.MAX_VALUE;
		int start = 0, end = 0, sum = 0, minLen = 0;
		while (end < len) {
			sum += nums[end];
			while (sum >= target) {
				minLen = end - start + 1;
				System.out.println("MinLen : "+minLen);
				minElementsLen = Math.min(minElementsLen, minLen);
				System.out.println("minElementsLen : "+minElementsLen);
				sum -= nums[start];
				System.out.println("Sum = ["+sum+"]");
				start++;
			}
			end++;
		}
		return minElementsLen == Integer.MAX_VALUE ? 0 : minElementsLen;
	}

}