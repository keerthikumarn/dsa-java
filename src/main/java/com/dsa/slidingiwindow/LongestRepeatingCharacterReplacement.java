package com.dsa.slidingiwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingCharacterReplacement {

	/*public static void main(String[] args) {
		System.out.println(characterReplacement("XYYX", 2));
		System.out.println(characterReplacementWithSW1("XYYX", 2));
	}*/

	/* Brute Force approach */
	/*private static int characterReplacement(String s, int k) {
		int resultingLen = 0;
		int strLen = s.length();
		for (int iIdx = 0; iIdx < strLen; iIdx++) {
			Map<Character, Integer> map = new HashMap<>();
			int freq = 0;
			for (int jIdx = iIdx; jIdx < strLen; jIdx++) {
				map.put(s.charAt(jIdx), map.getOrDefault(s.charAt(jIdx), 0) + 1);
				freq = Math.max(freq, map.get(s.charAt(jIdx)));
				if ((jIdx - iIdx + 1) - freq <= k) {
					resultingLen = Math.max(resultingLen, jIdx - iIdx + 1);
				}
			}
		}
		return resultingLen;
	}*/

	/* Sliding Window Approach */
	public int characterReplacementWithSW1(String s, int k) {
		int resultingLen = 0;
		Set<Character> set = new HashSet<>();
		// add all the chars to the array
		for (char ch : s.toCharArray()) {
			set.add(ch);
		}
		for (char ch : set) {
			int count = 0;
			int left = 0;
			for (int right = 0; right < s.length(); right++) {
				if (s.charAt(right) == ch) {
					count++;
				}
				while ((right - left + 1) - count > k) {
					if (s.charAt(left) == ch) {
						count--;
					}
					left++;
				}
				resultingLen = Math.max(resultingLen, right - left + 1);
			}
		}
		return resultingLen;
	}

}
