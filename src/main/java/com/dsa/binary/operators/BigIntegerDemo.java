package com.dsa.binary.operators;

import java.math.BigInteger;

public class BigIntegerDemo {

	public static void main(String[] args) {
		BigInteger bigInt = new BigInteger("2300");
		int num = 3;
		BigInteger changedRightShift = bigInt.shiftRight(num);
		String rightShiftValue = "After applying shiftRight by Shift Distance " + num + " on " + bigInt + " New Value is "
				+ changedRightShift;
		System.out.println(rightShiftValue);
	}

}
