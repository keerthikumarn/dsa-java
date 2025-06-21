package com.standalone.cache.demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StandaloneCacheDemo {

	public static void main(String[] args) {
		System.out.println("Starting Generic Standalone Cache System...");
		testCustomObjectCache();
	}

	@SuppressWarnings("unchecked")
	private static void testCustomObjectCache() {
		System.out.println("\n=== Testing Custom (Student) Object ===");
		CacheInterface<Student> cacheInterface = new CacheInterfaceImpl<>();
		ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
		List<String> studentNames = Arrays.asList("Keerthi", "Vineeth", "Raghav");
		try {
			// Start multiple producers
			for (int i = 1; i <= 3; i++) {
				executorService.submit(new Producer(cacheInterface, "Producer-" + i, studentNames));
			}
			// Start multiple consumers
			for (int i = 1; i <= 2; i++) {
				executorService.submit(new Consumer(cacheInterface, "Consumer-" + i));
			}
			// Let the system run for a while
			Thread.sleep(10000);
			System.out.println("\nFinal cache size: " + cacheInterface.size());
			System.out.println("Cache is empty: " + cacheInterface.isCacheEmpty());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} finally {
			gracefulShutdown(executorService);
		}
	}

	private static void gracefulShutdown(ExecutorService executorService) {
		executorService.shutdown();
		try {
			if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
				executorService.shutdownNow();
				if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
					System.err.println("ExecutorService did not terminate");
				}
			}
		} catch (InterruptedException e) {
			executorService.shutdownNow();
			Thread.currentThread().interrupt();
		}
	}

}
