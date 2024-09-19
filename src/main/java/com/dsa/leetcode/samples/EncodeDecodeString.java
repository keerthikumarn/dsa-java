package com.dsa.leetcode.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("neet", "code", "love", "you");
		String encodedStr = encode(strList);
		List<String> decodedStrList = decode(encodedStr);
	}

	private static String encode(List<String> strs) {
		StringBuilder sBuilder = new StringBuilder();
		for (String str : strs) {
			sBuilder.append(str.length()).append("@").append(str);
		}
		return sBuilder.toString();
	}

	private static List<String> decode(String encoded) {
		List<String> decodedWordsList = new ArrayList<>();
		StringBuilder currentStr = new StringBuilder();
		int count = 0;
		for (char ch : encoded.toCharArray()) {
			if (ch == '@') {
				count = Integer.parseInt(currentStr.toString());
				currentStr.setLength(0);
			} else if (count > 0) {
				currentStr.append(ch);
				count--;
				if (count == 0) {
					decodedWordsList.add(currentStr.toString());
					currentStr.setLength(0);
				}
			} else {
				currentStr.append(ch);
			}
		}

		return decodedWordsList;
	}

}
