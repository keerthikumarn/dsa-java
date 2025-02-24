package com.dsa.leetcode.samples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestWarnAndSaveThePrisoner {
	private WarnAndSaveThePrisoner obj;
	
	@BeforeEach
	void setUp() {
		obj = new WarnAndSaveThePrisoner();
	}
	@Test
	void warnAndSaveThePrisonerNormalCase() {
		assertEquals(2, obj.warnAndSaveThePrisoner(5, 2, 1));
	}

	@Test
	void warnAndSaveThePrisonerWrapAround() {
		assertEquals(1, obj.warnAndSaveThePrisoner(5, 2, 5));
	}

	@Test
	void warnAndSaveThePrisonerSinglePrisoner() {
		assertEquals(1, obj.warnAndSaveThePrisoner(1, 1, 1));
	}

	@Test
	void warnAndSaveThePrisonerSingleCandy() {
		assertEquals(3, obj.warnAndSaveThePrisoner(5, 1, 3));
	}

	@Test
	void warnAndSaveThePrisonerMultipleWrapArounds() {
		assertEquals(4, obj.warnAndSaveThePrisoner(5, 8, 2));
	}
}
