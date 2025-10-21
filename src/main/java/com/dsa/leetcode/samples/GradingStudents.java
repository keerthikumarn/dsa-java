package com.dsa.leetcode.samples;

import java.util.List;

public class GradingStudents {

	public List<Integer> gradingStudents(List<Integer> grades) {
		if(grades == null || grades.isEmpty()) {
			return null;
		}
		
		for(int grdIdx = 0; grdIdx < grades.size(); grdIdx++) {
			int grade = grades.get(grdIdx);
			if (grade >= 38) {
				int nextMultipleOf5 = ((grade / 5) + 1) * 5;
				if ((nextMultipleOf5 - grade) < 3) {
					grades.set(grdIdx, nextMultipleOf5);
				}
			}
		}
		return grades;
	}

}
