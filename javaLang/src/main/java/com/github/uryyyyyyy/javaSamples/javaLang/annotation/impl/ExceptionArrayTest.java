package com.github.uryyyyyyy.javaSamples.javaLang.annotation.impl;

import java.util.ArrayList;
import java.util.List;

import com.github.uryyyyyyy.javaSamples.javaLang.annotation.marker.ExceptionArrayAnnotation;

public class ExceptionArrayTest {

	@ExceptionArrayAnnotation(ArithmeticException.class)
	public static void ml() { // テス ト は成功すべき
		int i = 0;
		i = i / i;
	}

	@ExceptionArrayAnnotation({ ArithmeticException.class, ArrayIndexOutOfBoundsException.class })
	public static void m2() { // テス ト は成功すべき
		int[] a = new int[0];
		int i = a[1];
		System.out.println(i);
	}

	@ExceptionArrayAnnotation(ArithmeticException.class)
	public static void m3() {
	} // テス ト は失敗すべき (例外な し)

	@ExceptionArrayAnnotation({ IndexOutOfBoundsException.class,
			NullPointerException.class })
	public static void doublyBad() {
		List<String> list = new ArrayList<String>();
		// このメソッドが IndexOutOfBoundsException か NullPointerException
		// をスローすることを仕様は許している。
		//どちらかにひっかかればテストとしては成功。
		list.addAll(5, null);
	}
}
