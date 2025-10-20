package com.dsa.leetcode.samples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestValidTags {
	
	private ValidTags validTags;

	@BeforeEach
	void setUp() throws Exception {
		validTags = new ValidTags();
	}

	@Test
    @DisplayName("Should extract content between valid tags")
    void extractContentBetweenValidTags() {
        String result = validTags.extractValidContent("<div><p>Example</p></div>");
        Assertions.assertEquals("Example", result);
    }

    @Test
    @DisplayName("Should return None when no valid tags are present")
    void returnNoneWhenNoValidTagsPresent() {
        String result = validTags.extractValidContent("<div>Example</span>");
        Assertions.assertEquals("None", result);
    }

    @Test
    @DisplayName("Should return None for empty string input")
    void returnNoneForEmptyStringInput() {
        String result = validTags.extractValidContent("");
        Assertions.assertEquals("None", result);
    }

    @Test
    @DisplayName("Should return None for string without tags")
    void returnNoneForStringWithoutTags() {
        String result = validTags.extractValidContent("Just some text");
        Assertions.assertEquals("None", result);
    }

    @Test
    @DisplayName("Should handle nested valid tags and extract innermost content")
    void handleNestedValidTagsAndExtractInnermostContent() {
        String result = validTags.extractValidContent("<div><span>Nested</span></div>");
        Assertions.assertEquals("Nested", result);
    }

    @Test
    @DisplayName("Should return None for self-closing tags")
    void returnNoneForSelfClosingTags() {
        String result = validTags.extractValidContent("<div/>");
        Assertions.assertEquals("None", result);
    }

    @Test
    @DisplayName("Should return None for mismatched tags")
    void returnNoneForMismatchedTags() {
        String result = validTags.extractValidContent("<div>Content</span>");
        Assertions.assertEquals("None", result);
    }

    @Test
    @DisplayName("Should extract content when multiple valid tags are present")
    void extractContentWhenMultipleValidTagsArePresent() {
        String result = validTags.extractValidContent("<div><p>First</p><p>Second</p></div>");
        Assertions.assertEquals("First", result);
    }

}
