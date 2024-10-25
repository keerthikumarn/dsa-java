package com.dsa.leetcode.samples;

public class FirstAndLastPositionElementArray {

	public static void main(String[] args) {
		System.out.println(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8));
		System.out.println(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6));
		System.out.println(searchRangeLogN(new int[] { 5, 7, 7, 8, 8, 10 }, 8));
		System.out.println(searchRangeLogN(new int[] { 5, 7, 7, 8, 8, 10 }, 6));
	}

	private static int[] searchRangeLogN(int[] nums, int target) {
		int[] result = new int[2];
		result[0] = findElementIndex(nums, target, true);
		result[1] = findElementIndex(nums, target, false);
		System.out.println("index-0: "+result[0]+", index-1: "+result[1]);
		return result;
	}
	
	private static int findElementIndex(int[] nums, int target, boolean findLeft) {
	    int left = 0;
	    int right = nums.length - 1;
	    int index = -1;
	    while (left <= right) {
	        int midIndex = left + (right - left) / 2;
	        if (nums[midIndex] == target) {
	            index = midIndex;
	            if (findLeft) {
	                right = midIndex - 1;
	            } else {
	                left = midIndex + 1;
	            }
	        } else if (nums[midIndex] < target) {
	            left = midIndex + 1;
	        } else {
	            right = midIndex - 1;
	        }
	    }
	    return index;
	}

	private static int findLeftElementIndex(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int firstIndex = -1;
		while (left <= right) {
			int midIndex = left + (right - left) / 2;
			if (nums[midIndex] == target) {
				firstIndex = midIndex;
				right = midIndex - 1;
			} else if (nums[midIndex] < target) {
				left = midIndex + 1;
			} else {
				right = midIndex - 1;
			}
		}
		return firstIndex;
	}

	private static int findRightElementIndex(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int lastIndex = -1;
		while (left <= right) {
			int midIndex = left + (right - left) / 2;
			if (nums[midIndex] == target) {
				lastIndex = midIndex;
				left = midIndex + 1;
			} else if (nums[midIndex] < target) {
				left = midIndex + 1;
			} else {
				right = midIndex - 1;
			}
		}
		return lastIndex;
	}

	/* Brute Force Approach */
	private static int[] searchRange(int[] nums, int target) {
		int start = -1;
		int end = -1;
		for (int idx = 0; idx < nums.length; idx++) {
			if (nums[idx] == target) {
				if (start == -1) {
					start = idx;
				}
				end = idx;
			}
		}
		return new int[] { start, end };
	}

}
