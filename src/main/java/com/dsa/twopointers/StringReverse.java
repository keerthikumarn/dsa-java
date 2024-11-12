package com.dsa.twopointers;

public class StringReverse {

	public static void main(String[] args) {
		System.out.println(strReverse("keerthi"));
	}

	/* 2 pointer approach */
	private static String strReverse(String string) {
		char[] chArr = string.toCharArray();
		int leftPtr = 0;
		int rightPtr = chArr.length - 1;
		while (leftPtr < rightPtr) {
			char tempCh = chArr[leftPtr];
			chArr[leftPtr] = chArr[rightPtr];
			chArr[rightPtr] = tempCh;
			leftPtr++;
			rightPtr--;
		}
		return new String(chArr);
	}

}
