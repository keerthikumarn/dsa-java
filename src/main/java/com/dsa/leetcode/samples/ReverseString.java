package com.dsa.leetcode.samples;

/*
 * Write a function that reverses a string. The input string is
 * given as an array of characters s. You must do this by
 * modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString {

	public void reverseString(char[] ch) {
		int left = 0;
		int right = ch.length - 1;
		while (left < right) {
			char temp = ch[left];
			ch[left] = ch[right];
			ch[right] = temp;
			left++;
			right--;
		}
	}
	
	/*public static void main(String[] args) {
		ReverseString reverser = new ReverseString();
        char[] input = {'h', 'e', 'l', 'l', 'o'};
        reverser.reverseString(input);
        System.out.println(input);
    }*/
}
