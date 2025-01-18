package com.custom.storage.engine;

import java.util.ArrayList;
import java.util.List;

public class BPlusTreeNode {

	private List<String> keys;
	private List<BPlusTreeNode> children;
	private boolean isLeaf;

	public BPlusTreeNode(boolean isLeaf) {
		this.isLeaf = isLeaf;
		this.keys = new ArrayList<>();
		this.children = new ArrayList<>();
	}

}
