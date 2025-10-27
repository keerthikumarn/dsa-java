package com.dsa.leetcode.samples;

public class BeautifulBinaryString {

	public int minSteps(int n, String strB) {
		int stepsCount = 0;
		String tmpStr = strB;
		while (tmpStr.indexOf("010") != -1) {
			tmpStr = tmpStr.replaceFirst("010", "011");
			stepsCount++;
		}
		return stepsCount;
	}
}
