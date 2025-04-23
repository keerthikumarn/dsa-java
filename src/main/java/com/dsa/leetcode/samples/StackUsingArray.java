package com.dsa.leetcode.samples;

public class StackUsingArray {
	private int maxSize;
	private int[] stackArray;
	private int top;

	public StackUsingArray(int size) {
		this.maxSize = size;
		this.stackArray = new int[maxSize];
		this.top = -1;
	}

	public void push(int value) {
		if (isFull()) {
			System.out.println("Stack overflow. Cannot push " + value);
			return;
		}
		stackArray[++top] = value;
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack underflow. Nothing to pop.");
			return -1;
		}
		return stackArray[top--];
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty.");
			return -1;
		}
		return stackArray[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	public void printStack() {
		if (isEmpty()) {
			System.out.println("Stack is empty.");
			return;
		}
		System.out.print("Stack contents: ");
		for (int i = 0; i <= top; i++) {
			System.out.print(stackArray[i] + " ");
		}
		System.out.println();
	}
}
