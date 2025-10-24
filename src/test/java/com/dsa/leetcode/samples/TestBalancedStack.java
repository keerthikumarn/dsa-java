package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBalancedStack {
	
	private BalancedStack balancedStack;

	@BeforeEach
	void setUp() throws Exception {
		balancedStack = new BalancedStack();
	}

	void returnsTrueForBalancedParentheses() {
        assertTrue(balancedStack.isBalanced("()"));
    }

    @Test
    void returnsTrueForBalancedBrackets() {
        assertTrue(balancedStack.isBalanced("[]"));
    }

    @Test
    void returnsTrueForBalancedBraces() {
        assertTrue(balancedStack.isBalanced("{}"));
    }

    @Test
    void returnsTrueForNestedBalancedSymbols() {
        assertTrue(balancedStack.isBalanced("{[()]}"));
    }

    @Test
    void returnsFalseForUnmatchedOpeningSymbols() {
        assertFalse(balancedStack.isBalanced("({["));
    }

    @Test
    void returnsFalseForUnmatchedClosingSymbols() {
        assertFalse(balancedStack.isBalanced(")}]"));
    }

    @Test
    void returnsFalseForMismatchedSymbols() {
        assertFalse(balancedStack.isBalanced("{[}]"));
    }

    @Test
    void returnsTrueForEmptyString() {
        assertTrue(balancedStack.isBalanced(""));
    }

    @Test
    void returnsFalseForSingleOpeningSymbol() {
        assertFalse(balancedStack.isBalanced("("));
    }

    @Test
    void returnsFalseForSingleClosingSymbol() {
        assertFalse(balancedStack.isBalanced(")"));
    }

}
