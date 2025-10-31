package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMarsExploration {

	private MarsExploration marsExploration;

	@BeforeEach
	void setUp() throws Exception {
		marsExploration = new MarsExploration();
	}
	
	@Test
    void returnsZeroWhenMessageIsUnaltered() {
        int result = marsExploration.marsExploration("SOS");
        assertEquals(0, result);
    }

    @Test
    void returnsCorrectCountForSingleAlteredCharacter() {
        int result = marsExploration.marsExploration("SOT");
        assertEquals(1, result);
    }

    @Test
    void returnsCorrectCountForMultipleAlteredCharacters() {
        int result = marsExploration.marsExploration("SOTSOQ");
        assertEquals(2, result);
    }

    @Test
    void handlesEmptyString() {
        int result = marsExploration.marsExploration("");
        assertEquals(0, result);
    }

    @Test
    void handlesLongUnalteredMessage() {
        int result = marsExploration.marsExploration("SOSSOSSOS");
        assertEquals(0, result);
    }

    @Test
    void handlesLongAlteredMessage() {
        int result = marsExploration.marsExploration("SOSTOTSOQ");
        assertEquals(3, result);
    }

    @Test
    void handlesMessageWithAllCharactersAltered() {
        int result = marsExploration.marsExploration("XYZXYZXYZ");
        assertEquals(9, result);
    }

}
