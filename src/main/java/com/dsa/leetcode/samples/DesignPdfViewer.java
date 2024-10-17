package com.dsa.leetcode.samples;

import java.util.List;

public class DesignPdfViewer {

	public static void main(String[] args) {
		List<Integer> heights = List.of(1, 3, 1, 3, 1, 1, 1, 2, 1, 3, 1, 3, 1, 1, 1, 3, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1);
		int area = designerPdfViewer(heights, "abc");
		System.out.println("Highlighted Area: " + area);
	}

	private static int designerPdfViewer(List<Integer> h, String word) {
		int maxHeight = 0;
		for (char ch : word.toCharArray()) {
			int chIndex = ch - 'a';
			maxHeight = Math.max(maxHeight, h.get(chIndex));
		}
		return maxHeight * word.length();
	}

}
