package com.masking.demo;

public class MaskingUtil {
	
	public static String maskValue(String columnName, String value) {
		if (value == null) {
			return null;
		}
		switch (columnName) {
		case "mobno":
			return maskMobileNumber(value);
		case "creditcardno":
			return maskCreditCard(value);
		default:
			return value;
		}
	}

	private static String maskMobileNumber(String mobile) {
		if (mobile.length() < 4) {
			return "****";
		}
		return "******" + mobile.substring(mobile.length() - 4);
	}

	private static String maskCreditCard(String creditCard) {
		if (creditCard.length() < 4) {
			return "****";
		}
		return "**** **** **** " + creditCard.substring(creditCard.length() - 4);
	}
}
