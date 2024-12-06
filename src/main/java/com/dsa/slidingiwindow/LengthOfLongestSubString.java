package com.dsa.slidingiwindow;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubString {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubString("keerthi"));
	}

	private static int lengthOfLongestSubString(String s) {
		int strLen = s.length();
		if (strLen < 1) {
			return 0;
		}
		if (strLen == 1) {
			return 1;
		}
		int leftPointer = 0;
		int rightPointer = 0;
		int max = 0;
		Set<Character> set = new HashSet<>();
		while (rightPointer < strLen) {
			if (!set.contains(s.charAt(rightPointer))) {
				set.add(s.charAt(rightPointer++));
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(leftPointer++));
			}
		}
		return max;
	}
}
