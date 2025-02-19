package com.dsa.leetcode.samples;

public class BeautifulDaysAtMovies {

	public static void main(String[] args) {
		BeautifulDaysAtMovies bdm = new BeautifulDaysAtMovies();
		System.out.println(bdm.beautifulDays(1, 100, 3));
	}

	public int beautifulDays(int i, int j, int k) {
		int daysCount = 0;
		for (int beautifulDay = i; beautifulDay <= j; beautifulDay++) {
			int reversedDay = reversedNum(beautifulDay);
			int daysDiff = Math.abs(beautifulDay - reversedDay);
			if (daysDiff % k == 0) {
				daysCount++;
			}
		}
		return daysCount;
	}

	private static int reversedNum(int num) {
		int reversedNum = 0;
		while (num > 0) {
			reversedNum = reversedNum * 10 + num % 10;
			num = num / 10;
		}
		return reversedNum;
	}

}
