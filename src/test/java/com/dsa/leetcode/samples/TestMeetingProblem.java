package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class TestMeetingProblem {

	@Test
	void testReturnsTrueWhenNoMeetings() {
		MeetingProblem meetingProblem = new MeetingProblem();
		assertTrue(meetingProblem.canAttendMeetings(Collections.emptyList()));
	}

	@Test
	void testReturnsTrueWhenSingleMeeting() {
		MeetingProblem meetingProblem = new MeetingProblem();
		assertTrue(meetingProblem.canAttendMeetings(Collections.singletonList(new Interval(0, 1))));
	}

	@Test
	void returnsTrueWhenNoOverlappingMeetings() {
		MeetingProblem meetingProblem = new MeetingProblem();
		List<Interval> intervals = Arrays.asList(new Interval(1, 5), new Interval(6, 10));
		assertTrue(meetingProblem.canAttendMeetings(intervals));
	}

	@Test
	void returnsFalseWhenOverlappingMeetings() {
		MeetingProblem meetingProblem = new MeetingProblem();
		List<Interval> intervals = Arrays.asList(new Interval(1, 5), new Interval(4, 10));
		assertFalse(meetingProblem.canAttendMeetings(intervals));
	}

	@Test
	void returnsFalseWhenMeetingsStartAtSameTime() {
		MeetingProblem meetingProblem = new MeetingProblem();
		List<Interval> intervals = Arrays.asList(new Interval(1, 5), new Interval(1, 10));
		assertFalse(meetingProblem.canAttendMeetings(intervals));
	}

	@Test
	void returnsTrueWhenMeetingsEndAndStartAtSameTime() {
		MeetingProblem meetingProblem = new MeetingProblem();
		List<Interval> intervals = Arrays.asList(new Interval(1, 5), new Interval(5, 10));
		assertTrue(meetingProblem.canAttendMeetings(intervals));
	}

}
