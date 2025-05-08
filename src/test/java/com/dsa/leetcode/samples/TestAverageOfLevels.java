package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAverageOfLevels {

	private AverageOfLevels averageOfLevels;

	@BeforeEach
	void setUp() {
		averageOfLevels = new AverageOfLevels();
	}

	@Test
	public void testBalancedTree() {
		TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

		List<Double> expected = Arrays.asList(3.0, 14.5, 11.0);
		assertEquals(expected, averageOfLevels.averageOfLevels(root));
	}

	@Test
	public void testSingleNode() {
		TreeNode root = new TreeNode(10);
		List<Double> expected = List.of(10.0);
		assertEquals(expected, averageOfLevels.averageOfLevels(root));
	}

	@Test
	public void testLeftSkewedTree() {
		TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(3, new TreeNode(2), null), null), null);

		List<Double> expected = List.of(5.0, 4.0, 3.0, 2.0);
		assertEquals(expected, averageOfLevels.averageOfLevels(root));
	}

	@Test
	public void testRightSkewedTree() {
		TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));

		List<Double> expected = List.of(1.0, 2.0, 3.0, 4.0);
		assertEquals(expected, averageOfLevels.averageOfLevels(root));
	}

	@Test
	public void testNullTree() {
		TreeNode root = null;
		List<Double> expected = List.of();
		assertEquals(expected, averageOfLevels.averageOfLevels(root));
	}

	@Test
	public void testNegativeValues() {
		TreeNode root = new TreeNode(-10, new TreeNode(-20), new TreeNode(-30));

		List<Double> expected = List.of(-10.0, -25.0);
		assertEquals(expected, averageOfLevels.averageOfLevels(root));
	}

}
