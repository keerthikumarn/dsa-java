package com.dsa.leetcode.samples;

public class MedianOfTwoArrays {

	// find the median of two sorted arrays
	public double findMedianOfSortedArrays(int[] num1, int[] num2) {
		int n1 = num1.length;
		int n2 = num2.length;
		if (n1 > n2) {
			return findMedianOfSortedArrays(num2, num1);
		}
		int low = 0;
		int high = n1;
		while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (n1 + n2 + 1) / 2 - partitionX;
            int L1 = (partitionX == 0) ? Integer.MIN_VALUE : num1[partitionX - 1];
            int R1 = (partitionX == n1) ? Integer.MAX_VALUE : num1[partitionX];
            int L2 = (partitionY == 0) ? Integer.MIN_VALUE : num2[partitionY - 1];
            int R2 = (partitionY == n2) ? Integer.MAX_VALUE : num2[partitionY];

            if (L1 <= R2 && L2 <= R1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else {
                    return Math.max(L1, L2);
                }
            } else if (L1 > R2) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted correctly");
	}
	
	public static void main(String[] args) {
		MedianOfTwoArrays obj = new MedianOfTwoArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(obj.findMedianOfSortedArrays(nums1, nums2));

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println(obj.findMedianOfSortedArrays(nums3, nums4));

        int[] nums5 = {0, 0};
        int[] nums6 = {0, 0};
        System.out.println(obj.findMedianOfSortedArrays(nums5, nums6));

        int[] nums7 = {};
        int[] nums8 = {1};
        System.out.println(obj.findMedianOfSortedArrays(nums7, nums8));
        
        int[] nums9 = {2};
        int[] nums10 = {};
        System.out.println(obj.findMedianOfSortedArrays(nums9, nums10));
    }
}
