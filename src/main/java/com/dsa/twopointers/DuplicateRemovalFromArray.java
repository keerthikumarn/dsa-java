package com.dsa.twopointers;

public class DuplicateRemovalFromArray {

	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        int newLength = removeDuplicates(nums);
        for (int idx = 0; idx < newLength; idx++) {
            System.out.print(nums[idx] + " ");
        }	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return -1;
		}
		int slowPtr = 0;
		for (int fastPtr = 1; fastPtr < nums.length; fastPtr++) {
			if (nums[fastPtr] != nums[slowPtr]) {
				slowPtr++;
				nums[slowPtr] = nums[fastPtr];
			}
		}
		return slowPtr + 1;
	}

}
