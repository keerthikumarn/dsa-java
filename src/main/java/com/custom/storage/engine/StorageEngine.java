package com.custom.storage.engine;

public interface StorageEngine {
	/* To persist the key-value pair info */
	void save(String key, String value);

	/* To get/fetch the values persisted based on the key */
	String get(String key);

	/* To delete the key from the storage */
	void delete(String key);
}
