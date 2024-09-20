package com.dsa.leetcode.samples;

public class PalindromeCheck {

	public static void main(String[] args) {
		String str = "Was it a car or a cat I saw?";
		System.out.println(isPalindrome(str));
	}

	private static boolean isPalindrome(String s) {
		StringBuilder sb1 = new StringBuilder(s);
		String cleanStr = sb1.toString().replaceAll("[^\\w-]", "").toLowerCase().replaceAll("\\s+", " ");
		StringBuilder sb2 = new StringBuilder(cleanStr).reverse();
		return cleanStr.equals(sb2.toString());

	}
}