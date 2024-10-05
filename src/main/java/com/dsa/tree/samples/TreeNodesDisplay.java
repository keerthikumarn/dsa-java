package com.dsa.tree.samples;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class TreeNodesDisplay {
	public static void printNodes(MyTreeNode node) {
		Queue<MyTreeNode> queue = new ArrayDeque<>();
		queue.add(node);

		MyTreeNode currentNode;
		Set<MyTreeNode> alreadyVisited = new HashSet<>();
		System.out.print("Visited nodes: ");
		while (!queue.isEmpty()) {
			currentNode = queue.remove();
			System.out.print(currentNode.getValue() + " | ");
			alreadyVisited.add(currentNode);
			queue.addAll(currentNode.getChildNodes());
			queue.removeAll(alreadyVisited);
		}
	}

}
