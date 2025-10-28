package com.dsa.leetcode.samples;

import java.util.Stack;

public class SuperReducedString {

	public String getReducedString(String s) {
		char[] ch = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (int idx = 0; idx < ch.length; idx++) {
			if (stack.empty()) {
				stack.push(ch[idx]);

			} else if (stack.peek() == ch[idx]) {
				stack.pop();
			} else {
				stack.push(ch[idx]);

			}
		}
		String str = "";
		while (!stack.isEmpty()) {
			str = stack.pop() + str;
		}
		return str;
	}

}
