package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfMatchingSubSeq {

	public int numMatchingSubseq(String s, String[] words) {
		Map<Character, List<Integer>> chIndexMap = new HashMap<>();
		for (int idx = 0; idx < s.length(); idx++) {
			chIndexMap.computeIfAbsent(s.charAt(idx), k -> new ArrayList<>()).add(idx);
		}
		int count = 0;
		for (String word : words) {
			if (isSubSeq(word, chIndexMap)) {
				count++;
			}
		}
		return count;
	}

	private boolean isSubSeq(String word, Map<Character, List<Integer>> chIndexMap) {
		int prevIdx = -1;
		for (char ch : word.toCharArray()) {
			if (!chIndexMap.containsKey(ch)) {
				return false;
			}
			List<Integer> idxList = chIndexMap.get(ch);
			int nextIdx = findNextIndex(idxList, prevIdx);
			if (nextIdx == -1) {
				return false;
			}
			prevIdx = idxList.get(nextIdx);
		}
		return true;
	}

	private int findNextIndex(List<Integer> indices, int prevIdx) {
		int left = 0, right = indices.size();
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (indices.get(mid) > prevIdx) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return (left < indices.size()) ? indices.get(left) : -1;
	}

}
