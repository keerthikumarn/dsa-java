package com.dsa.leetcode.samples;

import java.util.concurrent.CountDownLatch;

public class PrintInOrder {
	private final CountDownLatch secondLatch;
	private final CountDownLatch thirdLatch;

	public PrintInOrder() {
        secondLatch = new CountDownLatch(1);
        thirdLatch = new CountDownLatch(1);
    }

	public void first(Runnable printFirst) throws InterruptedException {
		printFirst.run();
		secondLatch.countDown();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		secondLatch.await(); // Wait until first() is executed
		printSecond.run();
		thirdLatch.countDown();
	}

	public void third(Runnable printThird) throws InterruptedException {
		thirdLatch.await();
		printThird.run();
	}
}
