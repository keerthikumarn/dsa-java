package com.dsa.leetcode.samples;

public class GameOfThrones {

	private static final String NO = "NO";
	private static final String YES = "YES";

	public String gameOfThrones(String s) {
		int a[] = new int[26];
		for (int idx = 0; idx < s.length(); idx++) {
			int index = s.charAt(idx) - 'a';
			a[index]++;
		}
		int oddCount = 0;
		for (int idx = 0; idx < 26; idx++) {
			if (a[idx] != 0) {
				if ((a[idx] & 1) == 1) {
					oddCount++;
				}
			}
		}
		return oddCount > 1 ? NO : YES;
	}
}
