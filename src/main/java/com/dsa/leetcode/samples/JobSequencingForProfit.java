package com.dsa.leetcode.samples;

import java.util.Arrays;

public class JobSequencingForProfit {

    public int[] jobScheduling(Job[] jobs, int n) {
        // Sort jobs in descending order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find the maximum deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        // Create a time slot array to track free slots
        int[] timeSlots = new int[maxDeadline + 1];
        Arrays.fill(timeSlots, -1); // -1 indicates the slot is free

        int jobCount = 0;
        int maxProfit = 0;

        // Iterate through all jobs
        for (Job job : jobs) {
            // Find a free slot for this job (starting from its deadline)
            for (int jobIndex = job.deadline; jobIndex > 0; jobIndex--) {
                if (timeSlots[jobIndex] == -1) {
                    // Assign the job to this slot
                    timeSlots[jobIndex] = job.id;
                    jobCount++;
                    maxProfit += job.profit;
                    break;
                }
            }
        }
        return new int[]{jobCount, maxProfit};
    }

    public static void main(String[] args) {
        // Example input
        Job[] jobs = {
            new Job(1, 4, 20),
            new Job(2, 1, 10),
            new Job(3, 1, 40),
            new Job(4, 1, 30)
        };
        JobSequencingForProfit obj = new JobSequencingForProfit();
        int[] result = obj.jobScheduling(jobs, jobs.length);
        System.out.println("Number of jobs done: " + result[0]);
        System.out.println("Maximum profit: " + result[1]);
    }
}