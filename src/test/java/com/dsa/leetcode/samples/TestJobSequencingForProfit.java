package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestJobSequencingForProfit {

	private JobSequencingForProfit obj;

	@BeforeEach
	void setUp() throws Exception {
		obj = new JobSequencingForProfit();
	}

	@Test
	void returnsCorrectResultForMultipleJobsWithDifferentDeadlines() {
		Job[] jobs = { new Job(1, 4, 20), new Job(2, 1, 10), new Job(3, 1, 40), new Job(4, 1, 30) };
		int[] result = obj.jobScheduling(jobs, jobs.length);
		assertArrayEquals(new int[] { 2, 60 }, result);
	}

	@Test
	void returnsZeroJobsAndZeroProfitWhenNoJobsProvided() {
		Job[] jobs = {};
		int[] result = obj.jobScheduling(jobs, jobs.length);
		assertArrayEquals(new int[] { 0, 0 }, result);
	}

	@Test
	void handlesSingleJobCorrectly() {
		Job[] jobs = { new Job(1, 2, 50) };
		int[] result = obj.jobScheduling(jobs, jobs.length);
		assertArrayEquals(new int[] { 1, 50 }, result);
	}

	@Test
	void handlesJobsWithSameDeadlineAndDifferentProfits() {
		Job[] jobs = { new Job(1, 2, 30), new Job(2, 2, 40), new Job(3, 2, 20) };
		int[] result = obj.jobScheduling(jobs, jobs.length);
		assertArrayEquals(new int[] { 2, 70 }, result);
	}

	@Test
	void handlesJobsWithDeadlinesExceedingMaxDeadline() {
		Job[] jobs = { new Job(1, 10, 100), new Job(2, 5, 50), new Job(3, 1, 20) };
		int[] result = obj.jobScheduling(jobs, jobs.length);
		assertArrayEquals(new int[] { 3, 170 }, result);
	}

	@Test
	void handlesJobsWithZeroProfit() {
		Job[] jobs = { new Job(1, 2, 0), new Job(2, 1, 0) };
		int[] result = obj.jobScheduling(jobs, jobs.length);
		assertArrayEquals(new int[] { 0, 0 }, result);
	}

}
