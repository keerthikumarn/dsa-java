package com.dsa.leetcode.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

class TestPrintInOrder {

	@Test
	void testExecutionOrder() throws InterruptedException, ExecutionException {
		PrintInOrder printOrder = new PrintInOrder();
		StringBuilder output = new StringBuilder();
		ExecutorService executor = Executors.newFixedThreadPool(3);

		Runnable printFirst = () -> output.append("first");
		Runnable printSecond = () -> output.append("second");
		Runnable printThird = () -> output.append("third");

		Future<?> thread1 = executor.submit(() -> {
			try {
				printOrder.first(printFirst);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Future<?> thread2 = executor.submit(() -> {
			try {
				printOrder.second(printSecond);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Future<?> thread3 = executor.submit(() -> {
			try {
				printOrder.third(printThird);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		thread1.get();
		thread2.get();
		thread3.get();

		executor.shutdown();
		assertEquals("firstsecondthird", output.toString());
	}

}
