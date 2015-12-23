package com.github.uryyyyyyy.javaSamples.rxJava;

import rx.Observable;
import rx.functions.Action1;

public class Init {
	public static void main( String[] args ){
		Observable<String> myObservable =  Observable.from(new String[]{"hello", "world"});
		myObservable.subscribe(new Action1<String>() {

			public void call(String s) {
				System.out.println("Hello " + s + "!");
			}

		});
	}
}