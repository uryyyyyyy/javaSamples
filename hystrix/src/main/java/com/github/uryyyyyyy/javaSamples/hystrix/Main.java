package com.github.uryyyyyyy.javaSamples.hystrix;

import com.netflix.hystrix.exception.HystrixRuntimeException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
//		String s = new CommandHelloWorld("Bob").execute();
//		System.out.println(s);
//		Future<String> s1 = new CommandHelloWorld("Bob").queue();
//		System.out.println(s1.get());

		//TODO: circuit-break can be worked at 1st time, but after, it doesn't be worked.
		for(int i=0; i<20; i++){
			sleep(100);
			try{
				String s = new CommandThatFailsFast().execute();
				System.out.println(s);
			}catch (HystrixRuntimeException e){
				System.out.println(e.getMessage());
			}
		}
	}

	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}