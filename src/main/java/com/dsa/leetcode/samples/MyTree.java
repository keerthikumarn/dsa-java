package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.List;

public class MyTree {
	private int value;
	private List<MyTree> children;

	public MyTree(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

	public int getValue() {
		return this.value;
	}

	public List<MyTree> getChildren() {
		return this.children;
	}

	public MyTree addChild(int value) {
		MyTree newChild = new MyTree(value);
		children.add(newChild);
		return newChild;
	}
}
