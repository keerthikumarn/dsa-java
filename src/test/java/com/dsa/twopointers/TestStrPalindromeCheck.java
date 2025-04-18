package com.dsa.twopointers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStrPalindromeCheck {

	private StrPalindromeCheck palindromeCheck;
	
	@BeforeEach
	void setUp() {
		palindromeCheck = new StrPalindromeCheck();
	}
	
	@Test
    public void testValidPalindromeTrueCases() {
        assertTrue(palindromeCheck.validPalindrome("bob"));
        assertTrue(palindromeCheck.validPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(palindromeCheck.validPalindrome("No lemon, no melon"));
        assertTrue(palindromeCheck.validPalindrome(" "));
        assertTrue(palindromeCheck.validPalindrome(""));
    }

    @Test
    public void testValidPalindromeFalseCases() {
        assertFalse(palindromeCheck.validPalindrome("kumar"));
        assertFalse(palindromeCheck.validPalindrome("hello"));
        assertFalse(palindromeCheck.validPalindrome("abcd"));
    }

    @Test
    public void testValidPalindromeWithSpecialCharacters() {
        assertTrue(palindromeCheck.validPalindrome("Madam, I'm Adam"));
        assertTrue(palindromeCheck.validPalindrome("Was it a car or a cat I saw?"));
    }

    @Test
    public void testValidPalindromeNonAlphaNumericOnly() {
        assertTrue(palindromeCheck.validPalindrome("!!!"));
    }
}
