package com.dsa.leetcode.samples;

public class PeakElementInArray {

	public static void main(String[] args) {
		/*int[] nums1 = new int[] { 1, 2, 3, 1 };
		int[] nums2 = new int[] { 1, 2, 1, 3, 5, 5, 4 };
		System.out.println(findPeakElement(nums1));
		System.out.println(findFirstPeakElement(nums2));*/
	}
	
	public int findFirstPeakElement(int[] nums) {
	    for (int idx = 0; idx < nums.length; idx++) {
	        if ((idx == 0 || nums[idx] > nums[idx - 1]) && 
	            (idx == nums.length - 1 || nums[idx] > nums[idx + 1])) {
	            return idx;
	        }
	    }
	    return nums.length - 1;
	}

	/*private static int findPeakElement(int[] nums) {
		int leftNum = 0;
		int rightNum = nums.length - 1;
		while (leftNum < rightNum) {
			int midNum = leftNum + (rightNum - leftNum) / 2;
			if (nums[midNum] < nums[midNum + 1])
				leftNum = midNum + 1;
			else
				rightNum = midNum;
		}
		return leftNum;
	}*/

}
