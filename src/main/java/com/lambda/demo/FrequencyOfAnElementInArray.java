package com.lambda.demo;

import java.util.Arrays;

public class FrequencyOfAnElementInArray {

	public int countFrequency(int[] nums, int element) {
		return (int) Arrays.stream(nums).filter(num -> num == element).count();
	}
}
