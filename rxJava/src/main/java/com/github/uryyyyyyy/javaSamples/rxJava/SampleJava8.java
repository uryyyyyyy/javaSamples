package com.github.uryyyyyyy.javaSamples.rxJava;

import rx.Observable;

public class SampleJava8 {
	public static void main( String[] args ){
		Observable.from(new String[]{"hello", "world"})
		.subscribe(System.out::println);
	}
}