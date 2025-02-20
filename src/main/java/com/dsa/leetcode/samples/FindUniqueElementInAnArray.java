package com.dsa.leetcode.samples;

public class FindUniqueElementInAnArray {

	public static void main(String[] args) {
		FindUniqueElementInAnArray obj = new FindUniqueElementInAnArray();
		int[] arr = { 2, 2, 1 };
		System.out.println(obj.findUniqueElement(arr));
	}

	public int findUniqueElement(int[] nums) {
		int uniqueElement = 0;
		for (int num : nums) {
			uniqueElement ^= num;
		}
		return uniqueElement;
	}

}
