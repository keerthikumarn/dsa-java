package com.dsa.leetcode.samples;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog cat cat dog"));
	}

	private static boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		// base condition
		if (pattern.length() != words.length) {
			return false;
		}
		Map<String, Character> wordToCharMap = new HashMap<>();
		Map<Character, String> charToWordMap = new HashMap<>();
		for (int idx = 0; idx < pattern.length(); idx++) {
			char ch = pattern.charAt(idx);
			System.out.println("Current char : " + ch);
			String word = words[idx];
			System.out.println("Current word : " + word);
			if (charToWordMap.containsKey(ch)) {
				if (!charToWordMap.get(ch).equals(word)) {
					return false;
				}
			} else {
				charToWordMap.put(ch, word);
			}

			if (wordToCharMap.containsKey(word)) {
				if (!wordToCharMap.get(word).equals(ch)) {
					return false;
				}
			} else {
				wordToCharMap.put(word, ch);
			}
		}
		return true;
	}
}
