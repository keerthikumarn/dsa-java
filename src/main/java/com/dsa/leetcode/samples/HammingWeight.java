package com.dsa.leetcode.samples;

public class HammingWeight {

	public static void main(String[] args) {
		HammingWeight weight = new HammingWeight();
		System.out.println(weight.hammingWeight(00000000000000000000000000010111));
	}

	public int hammingWeight(int n) {
		int count = 0;
		while (n > 0) {
			count = count + (n & 1);
			n = n >> 1;
		}
		return count;
	}

}
