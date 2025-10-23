package com.dsa.leetcode.samples;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTelephoneDirectory {

	private TelephoneDirectory directory;

	@BeforeEach
	void setUp() throws Exception {
		directory = new TelephoneDirectory();
	}

	@Test
	void shouldPrintPhoneNumberWhenNameExistsInPhonebook() {
		Map<String, Integer> phonebook = new HashMap<>();
		phonebook.put("keerthi", 123456789);
		phonebook.put("raghav", 1122334455);
		TelephoneDirectory directory = new TelephoneDirectory();
		directory.findPhoneNumByName(phonebook, "keerthi");
	}

	@Test
	void shouldPrintNoPhoneNumberFoundWhenNameDoesNotExistInPhonebook() {
		Map<String, Integer> phonebook = new HashMap<>();
		phonebook.put("keerthi", 123456789);
		phonebook.put("raghav", 1122334455);
		TelephoneDirectory directory = new TelephoneDirectory();
		directory.findPhoneNumByName(phonebook, "unknown");
	}

	@Test
	void shouldPrintInvalidInputWhenPhonebookIsNull() {
		TelephoneDirectory directory = new TelephoneDirectory();
		directory.findPhoneNumByName(null, "keerthi");
	}

	@Test
	void shouldPrintInvalidInputWhenPhonebookIsEmpty() {
		Map<String, Integer> phonebook = new HashMap<>();
		TelephoneDirectory directory = new TelephoneDirectory();
		directory.findPhoneNumByName(phonebook, "keerthi");
	}

	@Test
	void shouldPrintInvalidInputWhenNameIsNull() {
		Map<String, Integer> phonebook = new HashMap<>();
		phonebook.put("keerthi", 123456789);
		TelephoneDirectory directory = new TelephoneDirectory();
		directory.findPhoneNumByName(phonebook, null);
	}

	@Test
	void shouldPrintInvalidInputWhenNameIsEmpty() {
		Map<String, Integer> phonebook = new HashMap<>();
		phonebook.put("keerthi", 123456789);
		TelephoneDirectory directory = new TelephoneDirectory();
		directory.findPhoneNumByName(phonebook, "");
	}

}
