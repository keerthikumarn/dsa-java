package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBreadthFirstSearchDemo {

	private BreadthFirstSearchDemo bfs;

	@BeforeEach
	void setUp() throws Exception {
		bfs = new BreadthFirstSearchDemo();
	}

	private MyTree buildSampleTree() {
		MyTree root = new MyTree(10);
		MyTree child1 = root.addChild(5);
		root.addChild(7);
		root.addChild(15);
		MyTree child1Child = child1.addChild(115);
		child1Child.addChild(207);
		child1Child.addChild(500);
		return root;
	}

	@Test
	public void testSearchExistingNodeRoot() {
		MyTree root = buildSampleTree();
		MyTree result = bfs.search(root, 10);
		assertNotNull(result);
		assertEquals(10, result.getValue());
	}

	@Test
	public void testSearchExistingNodeLeaf() {
		MyTree root = buildSampleTree();
		MyTree result = bfs.search(root, 500);
		assertNotNull(result);
		assertEquals(500, result.getValue());
	}

	@Test
	public void testSearchNonExistingNode() {
		MyTree root = buildSampleTree();
		MyTree result = bfs.search(root, 999);
		assertNull(result);
	}

	@Test
	public void testSearchIntermediateNode() {
		MyTree root = buildSampleTree();
		MyTree result = bfs.search(root, 115);
		assertNotNull(result);
		assertEquals(115, result.getValue());
	}

	@Test
	public void testSearchInSingleNodeTree() {
		MyTree root = new MyTree(42);
		MyTree result = bfs.search(root, 42);
		assertNotNull(result);
		assertEquals(42, result.getValue());
	}

	@Test
	public void testSearchInEmptyTree() {
		MyTree result = bfs.search(null, 100);
		assertNull(result);
	}

}
