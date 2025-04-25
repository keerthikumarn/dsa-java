package com.dsa.leetcode.samples;

public class CountVowels {

	public int countVowels(String str) {
		int count = 0;
		for (int idx = 0; idx < str.length(); idx++) {
			if (isVowel(str.charAt(idx))) {
				count++;
			}
		}
		return count;
	}

	private boolean isVowel(char ch) {
		ch = Character.toUpperCase(ch);
		return (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
	}
}
