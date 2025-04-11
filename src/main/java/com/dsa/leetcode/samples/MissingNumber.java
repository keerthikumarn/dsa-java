package com.dsa.leetcode.samples;

public class MissingNumber {

	/*public static void main(String[] args) {
		System.out.println(missingNumber(new int[] { 1, 2, 3 }));
		System.out.println(missingNumber(new int[] { 0, 2 }));
	}*/

	public int missingNumber(int[] nums) {
		int missingNumber = nums.length;
		for (int idx = 0; idx < nums.length; idx++) {
			missingNumber = missingNumber + idx - nums[idx];
		}
		return missingNumber;
	}

}
