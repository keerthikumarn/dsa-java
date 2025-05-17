package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestJumpingOnClouds {

	private JumpingOnClouds jumpingOnClouds = null;
	
	@BeforeEach
	void setUp() {
		jumpingOnClouds = new JumpingOnClouds();
	}

    @Test
    public void testAllZeroClouds_SimpleJump() {
        int[] c = {0, 0, 0, 0, 0, 0};
        int k = 2;
        // Every jump costs 1 energy, no penalty clouds
        // 6 elements, jumping every 2 -> 3 jumps: 100 - 3 = 97
        assertEquals(97, jumpingOnClouds.jumpingOnClouds(c, k));
    }

    @Test
    public void testWithThunderclouds() {
        int[] c = {0, 0, 1, 0, 0, 1, 1, 0};
        int k = 2;
        // Path: 0 → 2 (1) → 4 (0) → 6 (1) → 0
        // Hits 2 thunderclouds: 2×2 = 4 penalty
        // 4 jumps: 4×1 = 4 energy spent
        // Total: 100 - 4 - 4 = 92
        assertEquals(92, jumpingOnClouds.jumpingOnClouds(c, k));
    }

    @Test
    public void testKEquals1() {
        int[] c = {0, 1, 0, 1, 0, 1};
        int k = 1;
        // Jumps on every index; 3 thunderclouds → 6 + (3×2) = 12 energy lost
        assertEquals(88, jumpingOnClouds.jumpingOnClouds(c, k));
    }

    @Test
    public void testKEqualsArrayLength() {
        int[] c = {1, 1, 1, 1};
        int k = 4;
        // Only jumps back to itself once
        // One jump: 100 - 1 - 2 = 97
        assertEquals(97, jumpingOnClouds.jumpingOnClouds(c, k));
    }

    @Test
    public void testNoThunderclouds_KEquals3() {
        int[] c = {0, 0, 0, 0, 0, 0};
        int k = 3;
        // Jump path: 0 → 3 → 0 (2 jumps)
        // 2×1 = 2 energy cost
        assertEquals(98, jumpingOnClouds.jumpingOnClouds(c, k));
    }

    @Test
    public void testAllThunderclouds() {
        int[] c = {1, 1, 1, 1};
        int k = 1;
        // 4 jumps, each to a thundercloud: 4×(1+2) = 12
        assertEquals(88, jumpingOnClouds.jumpingOnClouds(c, k));
    }

}
