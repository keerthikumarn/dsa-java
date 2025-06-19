package com.standalone.cache.demo;

import java.util.List;

public interface CacheInterface<T> {

	public List<T> read(int key);

	public String writeToCache(int key, List<T> objects);
	
	public boolean isCacheEmpty();
	
	public int size();
}
