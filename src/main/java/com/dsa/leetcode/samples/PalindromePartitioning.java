package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		traceBack(s, 0, new ArrayList<>(), result);
		return result;
	}

	private void traceBack(String s, int start, List<String> currList, List<List<String>> result) {
		if (start == s.length()) {
			result.add(new ArrayList<>(currList));
			return;
		}

		for (int end = start + 1; end <= s.length(); end++) {
			String subString = s.substring(start, end);
			if (isPalindrome(subString)) {
				currList.add(subString);
				traceBack(s, end, currList, result);
				currList.remove(currList.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String subString) {
		boolean isPalindrome = true;
		int left = 0;
		int right = subString.length() - 1;
		while (left < right) {
			if (subString.charAt(left++) != subString.charAt(right--)) {
				isPalindrome = false;
			}
		}
		return isPalindrome;
	}

}
