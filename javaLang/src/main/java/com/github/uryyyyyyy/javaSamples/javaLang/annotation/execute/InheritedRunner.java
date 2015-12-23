package com.github.uryyyyyyy.javaSamples.javaLang.annotation.execute;

import com.github.uryyyyyyy.javaSamples.javaLang.annotation.impl.InheritedImpl;
import com.github.uryyyyyyy.javaSamples.javaLang.annotation.marker.InheritedAnnotation;
/**
 * 
 * 継承したやつが勝つらしい。
 */
public class InheritedRunner {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException{
		System.out.println(InheritedImpl.class.getMethod("doStuff").getAnnotation(InheritedAnnotation.class).value());
	}
}
