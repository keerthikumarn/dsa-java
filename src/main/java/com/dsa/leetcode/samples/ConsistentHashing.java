package com.dsa.leetcode.samples;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing {

	private TreeMap<Long, String> ring;
	private int noOfReplicas;
	private final MessageDigest md;

	public ConsistentHashing(int noOfReplicas) throws NoSuchAlgorithmException {
		this.ring = new TreeMap<>();
		this.noOfReplicas = noOfReplicas;
		this.md = MessageDigest.getInstance("MD5");
	}

	public void addServer(String server) {
		for (int idx = 0; idx < noOfReplicas; idx++) {
			long hashCode = generateHash(server + idx);
			System.out.println("Generated hashcode in addServer : " + hashCode);
			ring.put(hashCode, server);
		}
	}

	public void removeServer(String server) {
		for (int idx = 0; idx < noOfReplicas; idx++) {
			long hash = generateHash(server + idx);
			ring.remove(hash);
		}
	}

	public String getServer(String key) {
		if (ring.isEmpty()) {
			return null;
		}
		long hashCode = generateHash(key);
		if (!ring.containsKey(hashCode)) {
			SortedMap<Long, String> tailMap = ring.tailMap(hashCode);
			hashCode = tailMap.isEmpty() ? ring.firstKey() : tailMap.firstKey();
		}
		System.out.println("hashCode returned : " + hashCode + " for the server : " + key);
		return ring.get(hashCode);
	}

	private long generateHash(String key) {
		md.reset();
		md.update(key.getBytes());
		byte[] digest = md.digest();
		long hash = ((long) (digest[3] & 0xFF) << 24) | ((long) (digest[2] & 0xFF) << 16)
				| ((long) (digest[1] & 0xFF) << 8) | ((long) (digest[0] & 0xFF));
		return hash;
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		ConsistentHashing ch = new ConsistentHashing(3);
		ch.addServer("server1");
		ch.addServer("server2");
		ch.addServer("server3");

		System.out.println("key1: is present on server: " + ch.getServer("key1"));
		System.out.println("key67890: is present on server: " + ch.getServer("key67890"));

		ch.removeServer("server1");
		System.out.println("After removing server1");

		System.out.println("key1: is present on server: " + ch.getServer("key1"));
		System.out.println("key67890: is present on server: " + ch.getServer("key67890"));
	}

}
