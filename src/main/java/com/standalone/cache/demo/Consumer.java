package com.standalone.cache.demo;

import java.util.List;
import java.util.Random;

public class Consumer<T> implements Runnable {

	private final CacheInterface<T> cacheInterface;
	private final String consumerName;
	private final Random random;

	public Consumer(CacheInterface<T> cacheInterface, String consumerName) {
		this.cacheInterface = cacheInterface;
		this.consumerName = consumerName;
		this.random = new Random();
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 20; i++) {
				if (cacheInterface.isCacheEmpty()) {
					System.out.println(consumerName + " - Cache is empty, retrying after 30 seconds...");
					Thread.sleep(30000);
					continue;
				}
				int key = random.nextInt(20);
				List<T> objects = cacheInterface.read(key);
				if (objects != null && !objects.isEmpty()) {
					System.out.println(consumerName + " - Successfully read data for key: " + key + " | Data: "
							+ objects.get(0).toString());
				} else {
					System.out.println(consumerName + " - No data found for key: " + key);
				}
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println(consumerName + " interrupted");
		}
	}

}
