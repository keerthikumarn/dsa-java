package com.lambda.demo;

import java.util.Comparator;
import java.util.List;

public class MinimumElementInList {
	public int findMinElement(List<Integer> numbers) {
		if (numbers == null || numbers.isEmpty()) {
			throw new IllegalArgumentException("List cannot be null or empty");
		}
		int minElement = numbers.stream().min(Comparator.naturalOrder()).get();
		return minElement;
	}
}
