package com.github.uryyyyyyy.javaSamples.javaLang.annotation.marker;

public @interface StringValueAnnotation {
	String value() default "defauluValue";	//文字列を引数とする例
}