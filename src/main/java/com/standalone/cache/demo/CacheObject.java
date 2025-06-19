package com.standalone.cache.demo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheObject<T> {

	private final Map<Integer, CacheDetails<T>> cache;
	private final ReentrantReadWriteLock lock;
	private final int maxSize;

	public CacheObject() {
		this.cache = new ConcurrentHashMap<>();
		this.lock = new ReentrantReadWriteLock();
		this.maxSize = 10;
	}

	public List<T> read(int key) {
		lock.readLock().lock();
		try {
			CacheDetails<T> cacheDetails = cache.get(key);
			if (cacheDetails != null) {
				cacheDetails.updateLastAccessTime();
				return cacheDetails.getList();
			}
			return null;
		} finally {
			lock.readLock().unlock();
		}
	}

	public void put(int key, List<T> value) {
		lock.writeLock().lock();
		try {
			if (cache.size() >= maxSize && !cache.containsKey(key)) {
				removeLeastRecentlyUsed();
			}
			cache.put(key, new CacheDetails<T>(value));
		} finally {
			lock.writeLock().unlock();
		}
	}

	private void removeLeastRecentlyUsed() {
		lock.writeLock().lock();
		try {
			if (cache.isEmpty())
				return;

			Integer lruKey = null;
			LocalDateTime oldestTime = null;
			for (Map.Entry<Integer, CacheDetails<T>> entry : cache.entrySet()) {
				LocalDateTime accessTime = entry.getValue().getLastAccessTime();
				if (oldestTime == null || accessTime.isBefore(oldestTime)) {
					oldestTime = accessTime;
					lruKey = entry.getKey();
				}
			}
			if (lruKey != null) {
				cache.remove(lruKey);
				System.out.println("Evicted key: " + lruKey + " from cache");
			}
		} finally {
			lock.writeLock().unlock();
		}
	}

	public int size() {
		lock.readLock().lock();
		try {
			return cache.size();
		} finally {
			lock.readLock().unlock();
		}
	}

	public boolean isEmpty() {
		lock.readLock().lock();
		try {
			return cache.isEmpty();
		} finally {
			lock.readLock().unlock();
		}
	}

	public boolean containsKey(int key) {
		lock.readLock().lock();
		try {
			return cache.containsKey(key);
		} finally {
			lock.readLock().unlock();
		}
	}
}
