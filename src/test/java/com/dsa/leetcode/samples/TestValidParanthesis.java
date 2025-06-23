package com.dsa.leetcode.samples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestValidParanthesis {
	
	private ValidParanthesis validParanthesis;
	
	@BeforeEach
	void setUp() {
		validParanthesis = new ValidParanthesis();
	}

	@Test
	void returnsTrueForEmptyString1() {
		assertTrue(validParanthesis.isValid(""));
	}

    @Test
    void returnsTrueForValidParentheses() {
        assertTrue(validParanthesis.isValid("()"));
    }

    @Test
    void returnsTrueForValidMixedParentheses() {
        assertTrue(validParanthesis.isValid("()[]{}"));
    }

    @Test
    void returnsFalseForMismatchedParentheses() {
        assertFalse(validParanthesis.isValid("(}"));
    }

    @Test
    void returnsTrueForNestedValidParentheses() {
        assertTrue(validParanthesis.isValid("([{}])"));
    }

    @Test
    void returnsFalseForIncorrectlyNestedParentheses() {
        assertFalse(validParanthesis.isValid("[(])"));
    }

    @Test
    void returnsTrueForEmptyString() {
        assertTrue(validParanthesis.isValid(""));
    }

    @Test
    void returnsFalseForSingleOpeningParenthesis() {
        assertFalse(validParanthesis.isValid("("));
    }

    @Test
    void returnsFalseForSingleClosingParenthesis() {
        assertFalse(validParanthesis.isValid(")"));
    }

    @Test
    void returnsFalseForUnmatchedOpeningParentheses() {
        assertFalse(validParanthesis.isValid("((("));
    }

    @Test
    void returnsFalseForUnmatchedClosingParentheses() {
        assertFalse(validParanthesis.isValid(")))"));
    }
}

