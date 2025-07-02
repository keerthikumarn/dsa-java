package com.lambda.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRemoveDuplicatesFromList {

	private RemoveDuplicatesFromList obj;

	@BeforeEach
	void setUp() throws Exception {
		obj = new RemoveDuplicatesFromList();
	}

	@Test
	public void testRemoveDuplicatesWithDuplicates() {
		List<String> input = Arrays.asList("keerthi", "kumar", "raghav", "vineeth", "kumar");
		List<String> expected = Arrays.asList("keerthi", "kumar", "raghav", "vineeth");
		List<String> result = obj.removeDuplicates(input);
		assertEquals(expected, result);
	}

	@Test
	public void testRemoveDuplicatesWithNoDuplicates() {
		List<String> input = Arrays.asList("keerthi", "raghav", "vineeth");
		List<String> expected = Arrays.asList("keerthi", "raghav", "vineeth");
		List<String> result = obj.removeDuplicates(input);
		assertEquals(expected, result);
	}

	@Test
	void testRemoveDuplicatesWithEmptyList() {
		List<String> input = Collections.emptyList();
		List<String> expected = Collections.emptyList();
		List<String> result = obj.removeDuplicates(input);
		assertEquals(expected, result);
	}

	@Test
	public void testRemoveDuplicatesWithAllDuplicates() {
		List<String> input = Arrays.asList("keerthi", "keerthi", "keerthi");
		List<String> expected = Arrays.asList("keerthi");
		List<String> result = obj.removeDuplicates(input);
		assertEquals(expected, result);
	}

	@Test
	public void testRemoveDuplicatesWithNullDuplicates() {
		List<String> input = Arrays.asList("keerthi", null, "raghav", "vineeth", null);
		List<String> expected = Arrays.asList("keerthi", null, "raghav", "vineeth");
		List<String> result = obj.removeDuplicates(input);
		assertEquals(expected, result);
	}

	@Test
	void testRemoveDuplicatesNullInput() {
		assertThrows(NullPointerException.class, () -> {
			obj.removeDuplicates(null);
		});
	}

}
