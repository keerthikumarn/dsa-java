package com.dsa.leetcode.samples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestGradingStudents {
	
	private GradingStudents gradingStudents;

	@BeforeEach
	void setUp() throws Exception {
		gradingStudents = new GradingStudents();
	}
	
	@Test
    @DisplayName("Should round grades correctly when difference is less than 3")
    void roundGradesWhenDifferenceIsLessThan3() {
        List<Integer> result = gradingStudents.gradingStudents(Arrays.asList(73, 67, 38, 33));
        Assertions.assertEquals(Arrays.asList(75, 67, 40, 33), result);
    }

    @Test
    @DisplayName("Should not round grades below 38")
    void doNotRoundGradesBelow38() {
        List<Integer> result = gradingStudents.gradingStudents(Arrays.asList(37, 33, 20));
        Assertions.assertEquals(Arrays.asList(37, 33, 20), result);
    }

    @Test
    @DisplayName("Should return null for null input")
    void returnNullForNullInput() {
        List<Integer> result = gradingStudents.gradingStudents(null);
        Assertions.assertNull(result);
    }

    @Test
    @DisplayName("Should return null for empty input list")
    void returnNullForEmptyInputList() {
        List<Integer> result = gradingStudents.gradingStudents(Collections.emptyList());
        Assertions.assertNull(result);
    }

    @Test
    @DisplayName("Should handle grades that are already multiples of 5")
    void handleGradesAlreadyMultiplesOf5() {
        List<Integer> result = gradingStudents.gradingStudents(Arrays.asList(40, 75, 85));
        Assertions.assertEquals(Arrays.asList(40, 75, 85), result);
    }

    @Test
    @DisplayName("Should handle single grade input")
    void handleSingleGradeInput() {
        GradingStudents gradingStudents = new GradingStudents();
        List<Integer> result = gradingStudents.gradingStudents(Collections.singletonList(84));
        Assertions.assertEquals(Collections.singletonList(85), result);
    }

    @Test
    @DisplayName("Should handle grades with no rounding needed")
    void handleGradesWithNoRoundingNeeded() {
        List<Integer> result = gradingStudents.gradingStudents(Arrays.asList(39, 67, 99));
        Assertions.assertEquals(Arrays.asList(40, 67, 100), result);
    }


}
