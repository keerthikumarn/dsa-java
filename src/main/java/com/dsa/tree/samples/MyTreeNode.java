package com.dsa.tree.samples;

import java.util.LinkedList;
import java.util.List;

public class MyTreeNode {

	private List<MyTreeNode> childNodes;
	private String value;

	public MyTreeNode(String value) {
		this.value = value;
		this.childNodes = new LinkedList<>();
	}

	public void addChildNode(MyTreeNode childNode) {
		childNodes.add(childNode);
	}
	
	public void showTreeNodes() {
	    TreeNodesDisplay.printNodes(this);
	  }

	public String getValue() {
		return value;
	}

	public List<MyTreeNode> getChildNodes() {
		return childNodes;
	}
	
	public void setChildNodes(List<MyTreeNode> childNodes) {
		this.childNodes = childNodes;
	}

}
