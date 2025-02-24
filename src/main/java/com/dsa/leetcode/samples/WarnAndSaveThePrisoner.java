package com.dsa.leetcode.samples;

public class WarnAndSaveThePrisoner {

	public static void main(String[] args) {
		//System.out.println(warnAndSaveThePrisoner(5, 2, 1));
		//System.out.println(warnAndSaveThePrisoner(5, 2, 2));
	}

	public int warnAndSaveThePrisoner(int n, int m, int s) {
		return (m - 1 + s - 1) % n + 1;
	}

}
