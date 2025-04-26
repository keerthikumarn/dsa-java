package com.dsa.leetcode.samples;

public class RemoveConsecutiveVowels {

	private boolean isVowel(char c) {
		return (c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u');
	}

	public void removeVowels(String str) {
		System.out.print(str.charAt(0));
		for (int i = 1; i < str.length(); i++) {
			if ((!isVowel(str.charAt(i - 1))) || (!isVowel(str.charAt(i)))) {
				System.out.print(str.charAt(i));
			}
		}
	}

}
