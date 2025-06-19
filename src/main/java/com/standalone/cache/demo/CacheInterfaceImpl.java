package com.standalone.cache.demo;

import java.util.List;

public class CacheInterfaceImpl<T> implements CacheInterface<T> {

	private final CacheObject<T> cacheObject;

	public CacheInterfaceImpl() {
		this.cacheObject = new CacheObject<>();
	}

	@Override
	public List<T> read(int key) {
		return cacheObject.read(key);
	}

	@Override
	public String writeToCache(int key, List<T> objects) {
		if (objects == null || objects.isEmpty()) {
			return "No objects to write to cache";
		}
		cacheObject.put(key, objects);
		return "Data written to cache successfully for key: " + key;
	}

	@Override
	public boolean isCacheEmpty() {
		return cacheObject.isEmpty();
	}

	@Override
	public int size() {
		return cacheObject.size();
	}

}
