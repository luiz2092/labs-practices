package com.bug.apibug;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainTest {

	public void test() {
		System.out.println("Hello Word");
	}

	public void test2(String str, Object... args) {
		System.out.println("Hello Word 2 " + str);
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		MainTest main = new MainTest();

		Method method = MainTest.class.getMethod("test", String.class);
		method.invoke(main, "param");

	}

}
