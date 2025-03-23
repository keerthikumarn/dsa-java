package com.dsa.leetcode.samples;

import java.util.Stack;

public class DecodeString {

	public String decodeString(String s) {
		Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0'); // Handles multi-digit numbers
            } else if (c == '[') {
                countStack.push(k);
                resultStack.push(currentString);
                currentString = new StringBuilder();
                k = 0; // Reset k after pushing
            } else if (c == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = resultStack.pop();
                for (int idx = 0; idx < repeatTimes; idx++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(c);
            }
        }
        return currentString.toString();
	}

}
