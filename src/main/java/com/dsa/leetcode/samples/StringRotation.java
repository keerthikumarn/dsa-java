package com.dsa.leetcode.samples;

public class StringRotation {

	public boolean isRotation(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		if (s1.length() != s2.length()) {
			return false;
		}
		String concatenated = s1 + s1;
		return concatenated.contains(s2);
	}
}
