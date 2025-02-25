package com.dsa.leetcode.samples;

public class ViralAdvertising {

	public static void main(String[] args) {
		//int days = 5; // Number of days to report
		//int result = viralAdvertising(days);
		//System.out.println("Cumulative Likes by Day " + days + ": " + result);
	}

	public int viralAdvertising(int n) {
		int noOfAdsShared = 5;
		int likes = 0;
		for (int day = 1; day <= n; day++) {
			int liked = noOfAdsShared / 2;
			likes += liked;
			noOfAdsShared = liked * 3;
		}
		return likes;
	}

}
