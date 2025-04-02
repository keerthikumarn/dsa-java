package com.dsa.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dsa.slidingiwindow.PermutationInStrings;

class TestPermutationInStrings {

	private PermutationInStrings obj;
	
	@BeforeEach
	void setUp() {
		obj = new PermutationInStrings();
	}
	
	@Test
    void testCheckInclusion_ValidPermutationExists() {
        assertTrue(obj.checkInclusion("ab", "eidbaooo"));
    }
    
    @Test
    void testCheckInclusion_NoPermutationExists() {
        assertFalse(obj.checkInclusion("ab", "eidboaoo"));
    }
    
    @Test
    void testCheckInclusion_ExactMatch() {
        assertTrue(obj.checkInclusion("abc", "bca"));
    }
    
    @Test
    void testCheckInclusion_SingleCharacterMatch() {
        assertTrue(obj.checkInclusion("a", "a"));
    }
    
    @Test
    void testCheckInclusion_SingleCharacterNoMatch() {
        assertFalse(obj.checkInclusion("a", "b"));
    }
    
    @Test
    void testCheckInclusion_EmptyStrings() {
        assertTrue(obj.checkInclusion("", ""));
    }
    
    @Test
    void testCheckInclusion_EmptyS1() {
        assertTrue(obj.checkInclusion("", "eidbaooo"));
    }
    
    @Test
    void testCheckInclusion_EmptyS2() {
        assertFalse(obj.checkInclusion("abc", ""));
    }
    
    @Test
    void testCheckInclusion_S1LongerThanS2() {
        assertFalse(obj.checkInclusion("abcd", "abc"));
    }

}
