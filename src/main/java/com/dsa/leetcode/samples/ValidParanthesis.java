package com.dsa.leetcode.samples;

import java.util.Stack;

public class ValidParanthesis {

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(}"));
	}

	private static boolean isValid(String str) {
		Stack<Character> leftChar = new Stack<>();
		for (char ch : str.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[') {
				leftChar.push(ch);
			} else if (ch == ')' && !leftChar.isEmpty() && leftChar.peek() == '(') {
				leftChar.pop();
			} else if (ch == '}' && !leftChar.isEmpty() && leftChar.peek() == '{') {
				leftChar.pop();
			} else if (ch == ']' && !leftChar.isEmpty() && leftChar.peek() == '[') {
				leftChar.pop();
			} else {
				return false;
			}
		}
		return leftChar.isEmpty();
	}

}
