package com.dsa.leetcode.samples;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("zxyzxyz"));
		System.out.println(lengthOfLongestSubstring("xxx"));

	}

	private static int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int left = 0;
		int length = 0;
		for (int idx = 0; idx < s.length(); idx++) {
			while (set.contains(s.charAt(idx))) {
				set.remove(s.charAt(left));
				left++;
			}
			set.add(s.charAt(idx));
			length = Math.max(length, idx - left + 1);
		}
		return length;
	}

}
