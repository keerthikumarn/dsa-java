package com.dsa.binary.operators;

import java.util.BitSet;

public class BitSetDemo {

	public static void main(String[] args) {
		BitSet bs1 = new BitSet();
		BitSet bs2 = new BitSet();
		BitSet bs3 = new BitSet();

		bs1.set(0);
		bs1.set(1);
		bs1.set(2);
		bs1.set(4);

		bs2.set(4);
		bs2.set(6);
		bs2.set(5);
		bs2.set(1);
		bs2.set(2);
		bs2.set(3);
		bs2.set(12);

		System.out.println("bs1 : " + bs1);
		System.out.println("bs2 : " + bs2);
		System.out.println("bs3 : " + bs3);

		System.out.println(bs1.nextSetBit(2));
		System.out.println(bs2.nextSetBit(0));
		System.out.println(bs3.nextSetBit(3));
	}

}
