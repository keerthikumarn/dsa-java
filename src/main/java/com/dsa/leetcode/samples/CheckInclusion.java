package com.dsa.leetcode.samples;

import java.util.HashMap;
import java.util.Map;

public class CheckInclusion {

	public static void main(String[] args) {

	}

	private static boolean checkInclusion(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();

		if (len1 > len2) {
			return false;
		}

		// Frequency maps for characters in s1 and the current window in s2
		Map<Character, Integer> s1CountMap = new HashMap();
		Map<Character, Integer> windowCountMap = new HashMap();

		// initialize the frequency map
		for (char ch : s1.toCharArray()) {
			s1CountMap.put(ch, s1CountMap.getOrDefault(ch, 0) + 1);
		}

		// Initialize the first window of size len1 in s2
		for (int idx = 0; idx < len1; idx++) {
			char ch = s2.charAt(idx);
			windowCountMap.put(ch, windowCountMap.getOrDefault(ch, 0) + 1);
		}

		// Check if the first window matches the frequency map of s1
		if (s1CountMap.equals(windowCountMap)) {
			return true;
		}

		// start sliding the window over s2
		for (int idx = len1; idx < len2; idx++) {
			char newChar = s2.charAt(idx);
			char oldChar = s2.charAt(idx - len1);
			// Add the new character to the window count
			windowCountMap.put(newChar, windowCountMap.getOrDefault(newChar, 0) + 1);
			// Remove the old character from the window count
			if (windowCountMap.get(oldChar) == 1) {
				// Remove it completely if count goes to zero
				windowCountMap.remove(oldChar);
			} else {
				windowCountMap.put(oldChar, windowCountMap.get(oldChar) - 1);
			}
			// Check if current window matches the frequency map of s1
			if (s1CountMap.equals(windowCountMap)) {
				return true;
			}
		}
		// no permutation exists/found
		return false;
	}

}
