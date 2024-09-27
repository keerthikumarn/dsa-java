package com.dsa.leetcode.samples;

public class SingleNumber {

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] { 3, 2, 3 }));
		System.out.println(singleNumber(new int[] { 7, 6, 6, 7, 8 }));
	}

	private static int singleNumber(int[] nums) {
		int singleNum = 0;
		for (int num : nums) {
			singleNum = singleNum ^ num;
		}
		return singleNum;
	}

}
