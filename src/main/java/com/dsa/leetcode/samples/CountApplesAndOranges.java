package com.dsa.leetcode.samples;

import java.util.List;

public class CountApplesAndOranges {
	
	public void countApplesAndOranges(int s, int t, int a, int b, 
			List<Integer> apples, List<Integer> oranges) {
		
		int appleCount = 0;
		int orangeCount = 0;
		for(int apple : apples) {
			int landingPosition = a + apple;
			if (landingPosition >= s && landingPosition <= t) {
				appleCount++;
			}
		}
		for (int orange : oranges) {
	        int landingPosition = b + orange;
	        if (landingPosition >= s && landingPosition <= t) {
	            orangeCount++;
	        }
	    }

	    System.out.println(appleCount);
	    System.out.println(orangeCount);

	}

}
