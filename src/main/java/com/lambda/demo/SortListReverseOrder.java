package com.lambda.demo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortListReverseOrder {

	public List<String> sortListInReverseOrder(List<String> list) {
		return list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	}
	
}
