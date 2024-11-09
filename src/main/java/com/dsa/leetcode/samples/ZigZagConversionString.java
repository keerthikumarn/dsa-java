package com.dsa.leetcode.samples;

public class ZigZagConversionString {

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
		System.out.println(convert("PAYPALISFIRING", 4));
	}

	private static String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		StringBuilder[] sbArr = new StringBuilder[numRows];
		int row = 0;
		int direction = 0;
		/* create no. of rows to be created */
		for (int idx = 0; idx < sbArr.length; idx++) {
			sbArr[idx] = new StringBuilder();
		}

		for (int idx = 0; idx < s.length(); idx++) {
			char ch = s.charAt(idx);
			row = row + direction;
			/* append the characters to be displayed in each row */
			sbArr[row].append(ch);
			/* decide to move the row to the zig zag direction or not */
			if (row == 0 || row == numRows - 1) {
				direction = (direction == 0) ? 1 : -direction;
			}
		}
		return convertToString(sbArr);
	}

	private static String convertToString(StringBuilder[] sbArr) {
		StringBuilder result = new StringBuilder();
		for (StringBuilder sb : sbArr) {
			result.append(sb.toString());
		}
		return result.toString();
	}

}
