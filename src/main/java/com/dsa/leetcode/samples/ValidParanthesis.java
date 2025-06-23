package com.dsa.leetcode.samples;

import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {

	public static void main(String[] args) {
		/*System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(}"));
		System.out.println(isValid("([{}])")); 
		System.out.println(isValid("[(])"));*/
	}

	public boolean isValid(String str) {
		Map<Character, Character> matchingPairs = Map.of(')', '(', '}', '{', ']', '[');
		Stack<Character> leftChar = new Stack<>();
		
		for (char ch : str.toCharArray()) {
			if (matchingPairs.containsValue(ch)) {
				leftChar.push(ch);
			} else if (matchingPairs.containsKey(ch)) {
				if (leftChar.isEmpty() || leftChar.pop() != matchingPairs.get(ch)) {
					return false;
				}
			} else {
				return false;
			}
		}
		return leftChar.isEmpty();
	}

	public boolean isValid1(String str) {
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
