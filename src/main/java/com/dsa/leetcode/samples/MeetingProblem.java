package com.dsa.leetcode.samples;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingProblem {

	public static void main(String[] args) {

	}

	public boolean canAttendMeetings(List<Interval> intervals) {
		// sort the intervals
		Collections.sort(intervals, Comparator.comparingInt(interval -> interval.start));
		for (int idx = 1; idx < intervals.size(); idx++) {
			Interval interval1 = intervals.get(idx - 1);
			Interval interval2 = intervals.get(idx);
			if (interval1.end > interval2.start) {
				return false;
			}
		}
		return true;
	}

}
