package com.dsa.leetcode.samples;

import java.util.HashMap;
import java.util.Map;

public class WordsToNumber {

	private static final Map<String, Integer> numberMap = new HashMap<>();
	private static final Map<String, Integer> multiplierMap = new HashMap<>();

	static {
		numberMap.put("zero", 0);
		numberMap.put("one", 1);
		numberMap.put("two", 2);
		numberMap.put("three", 3);
		numberMap.put("four", 4);
		numberMap.put("five", 5);
		numberMap.put("six", 6);
		numberMap.put("seven", 7);
		numberMap.put("eight", 8);
		numberMap.put("nine", 9);
		numberMap.put("ten", 10);
		numberMap.put("eleven", 11);
		numberMap.put("twelve", 12);
		numberMap.put("thirteen", 13);
		numberMap.put("fourteen", 14);
		numberMap.put("fifteen", 15);
		numberMap.put("sixteen", 16);
		numberMap.put("seventeen", 17);
		numberMap.put("eighteen", 18);
		numberMap.put("nineteen", 19);
		numberMap.put("twenty", 20);
		numberMap.put("thirty", 30);
		numberMap.put("forty", 40);
		numberMap.put("fifty", 50);
		numberMap.put("sixty", 60);
		numberMap.put("seventy", 70);
		numberMap.put("eighty", 80);
		numberMap.put("ninety", 90);

		multiplierMap.put("hundred", 100);
		multiplierMap.put("thousand", 1_000);
		multiplierMap.put("million", 1_000_000);
		multiplierMap.put("billion", 1_000_000_000);
	}

	public static int wordsToNumber(String words) {
		String[] tokens = words.split("\\s+");
		int num = 0;
		int total = 0;
		for (String token : tokens) {
			token = token.toLowerCase();
			if (numberMap.containsKey(token)) {
				num += numberMap.get(token);
			} else if (multiplierMap.containsKey(token)) {
				num *= multiplierMap.get(token);
				if (token.equals("thousand") || token.equals("million") || token.equals("billion")) {
					total += num;
					num = 0;
				}
			}
		}
		return total + num;
	}

	public static void main(String[] args) {
		System.out.println(wordsToNumber("three hundred million"));
		System.out.println(wordsToNumber("four hundred seven"));
		System.out.println(wordsToNumber("one thousand nine hundred ninety seven"));
		
	}

}
