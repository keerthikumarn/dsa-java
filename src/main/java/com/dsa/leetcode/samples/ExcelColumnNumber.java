package com.dsa.leetcode.samples;

public class ExcelColumnNumber {

	public int titleToNumber(String columnTitle) {
		int columNumber = 0;
		for (int idx = 0; idx < columnTitle.length(); idx++) {
			char ch = columnTitle.charAt(idx);
			int chValue = ch - 'A' + 1;
			columNumber = columNumber * 26 + chValue;
		}
		return columNumber;
	}

}
