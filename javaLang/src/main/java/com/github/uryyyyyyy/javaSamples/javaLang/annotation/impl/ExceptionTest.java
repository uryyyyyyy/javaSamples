package com.github.uryyyyyyy.javaSamples.javaLang.annotation.impl;

import com.github.uryyyyyyy.javaSamples.javaLang.annotation.marker.ExceptionTestAnnotation;

public class ExceptionTest {

	@ExceptionTestAnnotation (ArithmeticException.class)
	public static void ml () { // テス ト は成功すべき
		int i = 0 ; 
		i = i / i; 
	}
	@ExceptionTestAnnotation (ArithmeticException. class)
	public static void m2 () { // テス ト は失敗すべき (誤っ た例外)
		int [] a = new int [0] ; 
		int i = a [1] ;
		System.out.println(i);
	}
	@ExceptionTestAnnotation (ArithmeticException. class)
	public static void m3 () { } // テス ト は失敗すべき (例外な し)

}
