package com.dsa.leetcode.samples;

import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstSearchDemo {

	public static void main(String[] args) {
		MyTree root = new MyTree(10);
		MyTree newChild = root.addChild(5);
		root.addChild(7);
		root.addChild(15);
		MyTree newChildChild = newChild.addChild(115);
		MyTree newChildChildChild = newChildChild.addChild(207);
		MyTree newChildChildChildChild = newChildChild.addChild(500);
		MyTree foundNode = search(root, 502);
		if (foundNode != null) {
			System.out.println(foundNode.getValue());
		} else {
			System.out.println("Found nothing!");
		}
	}

	public static MyTree search(MyTree root, int value) {
		Queue<MyTree> queue = new ArrayDeque<MyTree>();
		queue.add(root);
		while (!queue.isEmpty()) {
			for (MyTree node : queue) {
				System.out.println(node.getValue());
			}
			MyTree currNode = queue.remove();
			if (currNode.getValue() == value) {
				System.out.println("Finished searching for the element with the value: " + value);
				return currNode;
			} else {
				queue.addAll(currNode.getChildren());
			}
		}
		return null;
	}

}
