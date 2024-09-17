package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramGrouping {

	public static void main(String[] args) {
		String[] strs = { "act", "pots", "tops", "cat", "stop", "hat" };
		System.out.println(groupAnagrams(strs));
	}

	private static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList<>();
		}
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			String key = new String(charArray);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(str);
		}
		return new ArrayList<>(map.values());
	}

}
