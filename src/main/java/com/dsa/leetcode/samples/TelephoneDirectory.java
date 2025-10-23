package com.dsa.leetcode.samples;

import java.util.HashMap;
import java.util.Map;

public class TelephoneDirectory {

	public void findPhoneNumByName(Map<String, Integer> phonebook, String name) {
		if (phonebook == null || phonebook.isEmpty() || name == null || name.isEmpty()) {
			System.out.println("Invalid Input !!");
			return;
		}
		if (phonebook.containsKey(name)) {
			System.out.println(phonebook.get(name));
		} else {
			System.out.println("No phone number found");
		}
	}

	public static void main(String[] args) {
		Map<String, Integer> phonebook = new HashMap<String, Integer>();
		phonebook.put("keerthi", 123456789);
		phonebook.put("raghav", 1122334455);
		phonebook.put("vineeth", 9988776);
		TelephoneDirectory directory = new TelephoneDirectory();
		directory.findPhoneNumByName(phonebook, "keerthi");
		directory.findPhoneNumByName(phonebook, "kumar");
		directory.findPhoneNumByName(phonebook, "vineeth");
		
	}

}
