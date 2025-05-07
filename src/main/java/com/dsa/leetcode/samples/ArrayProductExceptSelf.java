package com.dsa.leetcode.samples;

public class ArrayProductExceptSelf {

	/*public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 4, 6 };
		System.out.println(productExceptSelf(nums));
	}*/

	public int[] productExceptSelf(int[] nums) {
		int[] resultArr = new int[nums.length];
		for (int iIndex = 0; iIndex < nums.length; iIndex++) {
			int product = 1;
			for (int jIndex = 0; jIndex < nums.length; jIndex++) {
				if(jIndex != iIndex) {
					product = product * nums[jIndex];
				}
			}
			resultArr[iIndex] = product;
		}
		return resultArr;
	}

}
