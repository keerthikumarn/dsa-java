package com.dsa.leetcode.samples;

import java.util.Arrays;

public class AnagramCheck {

	/*public static void main(String[] args) {
		System.out.println(isAnagram("racecar", "carrace"));
	}*/

	public boolean isAnagram(String s, String t) {
		boolean isAnagram = false;
		String str1 = getSortedString(s);
		String str2 = getSortedString(t);
		if (str1.equals(str2)) {
			isAnagram = true;
		}
		return isAnagram;
	}

	private String getSortedString(String s) {
		char tempArr[] = s.toCharArray();
		Arrays.sort(tempArr);
		return new String(tempArr);
	}

}
