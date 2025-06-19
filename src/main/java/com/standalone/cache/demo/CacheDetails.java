package com.standalone.cache.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;

public class CacheDetails {

	private List<T> list;
	private LocalDateTime lastAccessTime;
	private LocalDateTime createdTime;

	public CacheDetails(List<T> list) {
		this.list = list;
		this.lastAccessTime = LocalDateTime.now();
		this.createdTime = LocalDateTime.now();
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public LocalDateTime getLastAccessTime() {
		return lastAccessTime;
	}

	public void updateLastAccessTime() {
		this.lastAccessTime = LocalDateTime.now();
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
}
