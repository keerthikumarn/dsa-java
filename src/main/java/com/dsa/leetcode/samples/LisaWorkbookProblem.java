package com.dsa.leetcode.samples;

import java.util.List;

/*
 * 
 */
public class LisaWorkbookProblem {

	public static int workbook(int n, int k, List<Integer> arr) {
		int specialCount = 0; // To count special problems
		int currentPage = 1; // Page indexing starts at 1

		for (int chapterIndex = 0; chapterIndex < n; chapterIndex++) {
			int totalProblems = arr.get(chapterIndex);
			int pagesNeeded = (totalProblems + k - 1) / k; // Calculate pages needed for this chapter
			for (int pageIndex = 0; pageIndex < pagesNeeded; pageIndex++) {
				int startProblemIndex = pageIndex * k + 1; // Problem indexing starts at 1
				int endProblemIndex = Math.min(startProblemIndex + k - 1, totalProblems);
				for (int problemIndex = startProblemIndex; problemIndex <= endProblemIndex; problemIndex++) {
					if (problemIndex == currentPage) {
						specialCount++;
					}
				}
				currentPage++; // Move to the next page
			}
		}
		return specialCount;
	}

}
