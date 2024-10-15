package com.dsa.leetcode.samples;

public class ReverseBits {

	public static void main(String[] args) {
		System.out.println(reverseBits(00000000000000000000000000010101));
	}

	private static int reverseBits(int n) {
		int reversedBit = 0;
		for (int idx = 0; idx < 32; idx++) {
			int bit = (n >> idx) & 1;
			reversedBit = reversedBit + (bit << (31 - idx));
		}
		return reversedBit;
	}

}
