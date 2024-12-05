package com.dsa.slidingiwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstrWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(findLongestSubstrWithoutRepeatingCharacters("abcbbcbbkhlkkmnhhgbabfds"));
	}

	private static int findLongestSubstrWithoutRepeatingCharacters(String str) {
		Map<Character, Integer> charMap = new HashMap<>();
		int maxLen = 0;
		int ptr = 0;
		for (int idx = 0; idx < str.length(); idx++) {
			char currChar = str.charAt(idx);
			if (charMap.containsKey(currChar)) {
				ptr = Math.max(ptr, charMap.get(currChar) + 1);
			}
			charMap.put(currChar, idx);
			maxLen = Math.max(maxLen, idx - ptr + 1);
		}
		return maxLen;
	}

}
