package com.standalone.cache.demo;

import java.util.List;
import java.util.Random;

public class Producer<T> implements Runnable {

	private final CacheInterface<T> cacheInterface;
	private final String producerName;
	private final Random random;
	private final List<T> data;

	public Producer(CacheInterface<T> cacheInterface, String producerName, List<T> data) {
		this.cacheInterface = cacheInterface;
		this.producerName = producerName;
		this.random = new Random();
		this.data = data;
	}

	@Override
	public void run() {
		try {
			for (int idx = 0; idx < data.size(); idx++) {
				int key = random.nextInt(20);
				String result = cacheInterface.writeToCache(key, data);
				System.out.println(producerName + " - " + result + " | Cache size: " + cacheInterface.size());
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println(producerName + " interrupted");
		}
	}

}
