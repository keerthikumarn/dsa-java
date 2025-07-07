package com.lambda.demo;

import java.util.Comparator;
import java.util.List;

public class MaxElementInList {

	public int findMaxElement(List<Integer> numbers) {
		if (numbers == null || numbers.isEmpty()) {
			throw new IllegalArgumentException("List cannot be null or empty");
		}
		int maxElement = numbers.stream().max(Comparator.naturalOrder()).get();
		return maxElement;
	}

}
