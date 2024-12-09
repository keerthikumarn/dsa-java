package com.dsa.slidingiwindow;

import java.util.Arrays;

public class PermutationInStrings {

	public static void main(String[] args) {
		System.out.println(checkInclusion("au", "eidbaooo"));
	}

	private static boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return false;
		}

		// Create frequency arrays for s1 and s2
		int[] s1Freq = new int[26];
		int[] s2Freq = new int[26];
		// Populate frequency array for s1 and the first window of s2
		for (int i = 0; i < s1.length(); i++) {
			s1Freq[s1.charAt(i) - 'a']++;
			s2Freq[s2.charAt(i) - 'a']++;
		}
		// Check initial window
		if (Arrays.equals(s1Freq, s2Freq))
			return true;

		// Slide the window over s2
		for (int idx = s1.length(); idx < s2.length(); idx++) {
			// Add new character to the window
			s2Freq[s2.charAt(idx) - 'a']++;

			// Remove the first character of the previous window
			s2Freq[s2.charAt(idx - s1.length()) - 'a']--;

			// Check if current window matches s1 frequency
			if (Arrays.equals(s1Freq, s2Freq)) {
				return true;
			}
		}
		return false;
	}

}
