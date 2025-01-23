package com.dsa.binary.operators;

import java.math.BigInteger;

public class BigIntegerDemo {

	public static void main(String[] args) {
		BigInteger bigInt = new BigInteger("2300");
		int num = 3;
		BigInteger changedRightShift = bigInt.shiftRight(num);
		String rightShiftValue = "After applying shiftRight by Shift Distance " + num + " on " + bigInt + " New Value is "
				+ changedRightShift;
		BigInteger changedLeftShift = bigInt.shiftLeft(num);
		String leftShiftValue = "After applying shiftRight by Shift Distance " + num + " on " + bigInt + " New Value is "
				+ changedLeftShift;
		
		System.out.println("Value after Right Shift : "+rightShiftValue);
		System.out.println("Value after Left Shift : "+leftShiftValue);
	}

}
