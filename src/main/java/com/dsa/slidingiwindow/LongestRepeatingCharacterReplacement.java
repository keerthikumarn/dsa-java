package com.dsa.slidingiwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		System.out.println(characterReplacement("XYYX", 2));
	}

	/* Brute Force approach */
	private static int characterReplacement(String s, int k) {
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
	}

}
