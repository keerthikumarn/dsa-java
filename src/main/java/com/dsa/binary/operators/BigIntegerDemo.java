package com.dsa.binary.operators;

import java.math.BigInteger;

public class BigIntegerDemo {

	public static void main(String[] args) {
		BigInteger bigInt = new BigInteger("2300");
		int num1 = 3;
		int num2 = 1;
		// Right shift
		BigInteger changedRightShift = bigInt.shiftRight(num1);
		String rightShiftValue = "After applying shiftRight by Shift Distance " + num1 + " on " + bigInt
				+ " New Value is " + changedRightShift;

		// Left shift
		BigInteger changedLeftShift = bigInt.shiftLeft(num1);
		String leftShiftValue = "After applying shiftRight by Shift Distance " + num1 + " on " + bigInt
				+ " New Value is " + changedLeftShift;

		// setBit
		BigInteger changedSetBit = bigInt.setBit(num2);
		String setBitValue = "After applying setBit at index " + num2 + " of " + bigInt + " New Value is " 
		+ changedSetBit;
		
		// Abs method
		BigInteger absInteger = new BigInteger("-8800"); 
        BigInteger absolutevalue = absInteger.abs(); 
              
        // Define result 
        String absResult ="BigInteger "+absInteger+ " and Absolute value is "+absolutevalue; 
		
		System.out.println("Value after Right Shift : " + rightShiftValue);
		System.out.println("Value after Left Shift : " + leftShiftValue);
		System.out.println("Value after setBit : " + setBitValue);
		System.out.println("Value after abs : " + absResult);
	}

}
