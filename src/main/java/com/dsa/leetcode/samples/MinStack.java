package com.dsa.leetcode.samples;

import java.util.Stack;

class MinStack {

	private Stack<Integer> myStack;

	public MinStack() {
		myStack = new Stack<>();
	}

	public void push(int val) {
		myStack.push(val);
	}

	public void pop() {
		myStack.pop();
	}

	public int top() {
		return myStack.peek();
	}

	public int getMin() {
		Stack<Integer> tempStack = new Stack<>();
		int min = myStack.peek();

		while (!myStack.isEmpty()) {
			min = Math.min(min, myStack.peek());
			tempStack.push(myStack.pop());
		}
		while (!tempStack.isEmpty()) {
			myStack.push(tempStack.pop());
		}
		return min;
	}
}
