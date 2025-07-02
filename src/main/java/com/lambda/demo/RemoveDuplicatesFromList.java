package com.lambda.demo;

import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromList {

	public List<String> removeDuplicates(List<String> list) {
		List<String> listWithNoDuplicates = list.stream().distinct().collect(Collectors.toList());
		return listWithNoDuplicates;
	}

}
