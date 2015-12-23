package com.github.uryyyyyyy.javaSamples.javaLang.annotation.impl;

import com.github.uryyyyyyy.javaSamples.javaLang.annotation.marker.StringValueAnnotation;;

public class StringValueImpl {
	@StringValueAnnotation(value = "文字列")	//値を指定する例1
	int n;
}


class StringValueSample2 {
	@StringValueAnnotation("文字列")	//値を指定する例2
	int n;
}