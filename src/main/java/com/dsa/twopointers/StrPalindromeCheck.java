package com.dsa.twopointers;

public class StrPalindromeCheck {

	public static void main(String[] args) {
		System.out.println(validPalindrome("kumar"));
		System.out.println(validPalindrome("bob"));
	}

	/* 2 pointer approach */
	private static boolean validPalindrome(String string) {
		int leftPtr = 0;
		int rightPtr = string.length() - 1;
		while (leftPtr < rightPtr) {
			while (Character.isLetterOrDigit(leftPtr)) {
				leftPtr++;
			}
			while (Character.isLetterOrDigit(rightPtr)) {
				rightPtr++;
			}
			if (Character.toLowerCase(string.charAt(leftPtr)) != Character.toLowerCase(string.charAt(rightPtr))) {
				return false;
			}
			leftPtr++;
			rightPtr--;
		}
		return true;
	}

}
