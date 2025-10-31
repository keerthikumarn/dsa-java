package com.dsa.leetcode.samples;

public class MarsExploration {

	public int marsExploration(String s) {
		int len = s.length();
		String msg = "SOS";
		int n = len / 3;
		String newString = msg;
		for (int idx = 1; idx < n; idx++) {
			newString += msg;
		}
		int count = 0;
		for (int idx = 0; idx < len; idx++) {
			if (newString.charAt(idx) != s.charAt(idx)) {
				count++;
			}
		}
		return count;
	}
}
