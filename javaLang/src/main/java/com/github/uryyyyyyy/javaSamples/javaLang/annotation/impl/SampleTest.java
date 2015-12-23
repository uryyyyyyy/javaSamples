package com.github.uryyyyyyy.javaSamples.javaLang.annotation.impl;

import com.github.uryyyyyyy.javaSamples.javaLang.annotation.marker.TestAnnotation;

public class SampleTest {
	
	@TestAnnotation public static void m1 () { } // テストは成功すべき
	public static void m2 () { } 
	@TestAnnotation public static void m3 () { // テストは失敗すべき
	throw new RuntimeException ("Boom"); 
	} 
	public static void m4 () { } 
	@TestAnnotation public void m5() { } //illegal usage;
	public static void m6 () { } 
	@TestAnnotation public static void m7 () { // テス ト は失敗すべき
	throw new RuntimeException("Crash"); 
	} 
	public static void m8 () { } 


}
