package com.lambda.demo;

import java.util.Comparator;
import java.util.List;

public class SortListReverseOrder {

	public void sortListInReverseOrder(List<String> list) {
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
}
