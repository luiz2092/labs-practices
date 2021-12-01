package com.example.demo;

public class MainTest {

	public static void main(String[] args) {
		String s = "Hola Mundo";
		System.out.println(reverseString(s));
	}

	public static String reverseString(String str) {
		if (str.isEmpty())
			return str;
		return reverseString(str.substring(1)) + str.charAt(0);
	}

}
