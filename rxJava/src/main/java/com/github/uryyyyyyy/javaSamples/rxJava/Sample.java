package com.github.uryyyyyyy.javaSamples.rxJava;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class Sample {
	public static void main( String[] args ){
		Observable<String> myObservable = Observable.create(
				new Observable.OnSubscribe<String>(){

					public void call(Subscriber<? super String> subscriber) {
						subscriber.onNext("Hello");
						subscriber.onNext("World");
						subscriber.onCompleted();
					}
				}
				);

		Observer<String> myObserver = new Observer<String>() {

			public void onCompleted() {
				// TODO Auto-generated method stub
				
			}

			public void onError(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}

			public void onNext(String s) {
				System.out.println(s);
				
			}
		};
		myObservable.subscribe(myObserver);
	}
}