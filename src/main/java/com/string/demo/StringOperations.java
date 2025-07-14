package com.string.demo;

public class StringOperations {

	public int getCombinedLength(String a, String b) {
		return a.length() + b.length();
	}

	public String isLexicographicallyGreater(String a, String b) {
		return a.compareTo(b) > 0 ? "Yes" : "No";
	}

	public String capitalizeFirstLetters(String a, String b) {
		return capitalize(a) + " " + capitalize(b);
	}

	private String capitalize(String str) {
		if (str == null || str.isEmpty())
			return str;
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

}
