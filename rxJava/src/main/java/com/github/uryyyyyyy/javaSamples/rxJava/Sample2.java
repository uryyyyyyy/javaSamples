package com.github.uryyyyyyy.javaSamples.rxJava;

import rx.Observable;
import rx.schedulers.Schedulers;

public class Sample2 {
	public static void main( String[] args ){
		Observable.from(new String[]{"hello", "world!"})
		.map(String::length)
		.subscribe(System.out::println);
		
		Observable.from(new String[]{"hello", "world!"})
		.flatMap(s -> Observable.from(s.split("")))
		.subscribe(System.out::println);
		
		Observable.from(new String[]{"hello", "world!"})
		.filter(s -> s.length() == 5)
		.subscribe(System.out::println);
		
		Observable.from(new String[]{"hello", "world!"})
		.subscribeOn(Schedulers.newThread())
		.subscribe(System.out::println);
	}
}