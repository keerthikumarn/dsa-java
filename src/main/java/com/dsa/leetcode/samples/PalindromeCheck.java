package com.dsa.leetcode.samples;

public class PalindromeCheck {

	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder("Was it a car or a cat I saw?");
		String cleanStr = sb1.toString().replaceAll("[^\\w-]", "").toLowerCase().replaceAll("\\s+", " ");
		StringBuilder sb2 = new StringBuilder(cleanStr).reverse();
		System.out.println(sb2);
	}
}