package com.dsa.tree.samples;

public class TreeHierarchyDemo {

	public static void main(String[] args) {
		MyTreeNode ceoNode = new MyTreeNode("CEO");
		MyTreeNode ctoNode = new MyTreeNode("CTO");
		MyTreeNode enggHead = new MyTreeNode("Engg Head");
		MyTreeNode archNode1 = new MyTreeNode("Architect-1");
		MyTreeNode archNode2 = new MyTreeNode("Architect-2");
		MyTreeNode devManager = new MyTreeNode("Dev Manager");
		MyTreeNode qaManager = new MyTreeNode("QA Manager");
		MyTreeNode dev1 = new MyTreeNode("Developer-1");
		MyTreeNode dev2 = new MyTreeNode("Developer-2");
		MyTreeNode qa1 = new MyTreeNode("QA-1");
		MyTreeNode qa2 = new MyTreeNode("QA-2");
		ceoNode.addChildNode(ctoNode);
		ctoNode.addChildNode(enggHead);
		enggHead.addChildNode(archNode1);
		enggHead.addChildNode(archNode2);
		enggHead.addChildNode(devManager);
		enggHead.addChildNode(qaManager);
		devManager.addChildNode(dev1);
		devManager.addChildNode(dev2);
		qaManager.addChildNode(qa1);
		qaManager.addChildNode(qa2);
		ceoNode.showTreeNodes();
	}

}
