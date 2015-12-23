package com.github.uryyyyyyy.javaSamples.javaLang.date.oldjava;

import java.util.Date;

public class DateSample {
	
	/**
	 * ~Java7
	 * 
	 */
	public static void main(String... args) {

		ln();
		pr("Date Objects");
		ln();
		
		Date now = new Date();
		pr(now);
		
		ln();
		pr("Date calc");
		ln();
		
		pr(now.before(now));

	}

	static void pr(Object s){
		System.out.println(s);
	}

	static void ln(){
		System.out.println("");
	}

}
