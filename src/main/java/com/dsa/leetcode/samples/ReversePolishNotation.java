package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversePolishNotation {

	public static void main(String[] args) {
		System.out.println(evalRPN(new String[] { "1", "2", "+", "3", "*", "4", "-" }));
	}

	private static int evalRPN(String[] tokens) {
		List<String> tokenList = new ArrayList<>(Arrays.asList(tokens));
		return evalRPN(tokenList);
	}

	private static int evalRPN(List<String> tokens) {
		String token = tokens.remove(tokens.size() - 1);

		if (!"+-*/".contains(token)) {
			return Integer.parseInt(token);
		}

		int right = evalRPN(tokens);
		int left = evalRPN(tokens);

		switch (token) {
		case "+":
			return left + right;
		case "-":
			return left - right;
		case "*":
			return left * right;
		case "/":
			return left / right;
		}
		return 0;
	}

}
