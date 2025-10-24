package com.dsa.leetcode.samples;

import java.util.Stack;

public class BalancedStack {

	public boolean isBalanced(String input) {
		Stack<Character> stack = new Stack<>();
		for (Character ch : input.toCharArray()) {
			if (ch == '[' || ch == '{' || ch == '(') {
				stack.push(ch);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char top = stack.pop();
				if ((ch == ']' && top != '[') || (ch == '}' && top != '{') || (ch == ')' && top != '(')) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

}
