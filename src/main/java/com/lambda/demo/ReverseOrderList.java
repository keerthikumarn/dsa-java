package com.lambda.demo;

import java.util.Comparator;
import java.util.List;

public class ReverseOrderList {

	public List<Integer> reverseOrder(List<Integer> numbers) {
		return numbers.stream().sorted(Comparator.reverseOrder()).toList();
	}

}
