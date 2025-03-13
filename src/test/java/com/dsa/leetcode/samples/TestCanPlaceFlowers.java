package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCanPlaceFlowers {
	
	private CanPlaceFlowers cpf;
	
	@BeforeEach
	void setUp() {
		cpf = new CanPlaceFlowers();
	}

	@Test
	void testCanPlaceFlowersShouldReturnTrue() {
		int[] flowerbed = { 1, 0, 0, 0, 1 };
		int n = 1;
		assertTrue(cpf.canPlaceFlowers(flowerbed, n));
	}

	@Test
	void testCanPlaceFlowersShouldReturnFalse() {
		int[] flowerbed = { 1, 0, 0, 0, 1 };
		int n = 2;
		assertFalse(cpf.canPlaceFlowers(flowerbed, n));
	}

}
