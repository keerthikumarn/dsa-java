package com.dsa.leetcode.samples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidTags {

	public static void main(String[] args) {
		ValidTags obj = new ValidTags();
		String code = obj.extractValidContent("<div><p>Example</p></div>");
		System.out.println(code);
	}

	public String extractValidContent(String string) {
		Pattern pattern = Pattern.compile("<(.+?)>([^<>]+)</\\1>");
		Matcher matcher = pattern.matcher(string);
		if(matcher.find()) {
			return matcher.group(2);
		}
		return "None";
	}

}
