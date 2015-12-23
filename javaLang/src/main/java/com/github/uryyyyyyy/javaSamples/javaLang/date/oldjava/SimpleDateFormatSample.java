package com.github.uryyyyyyy.javaSamples.javaLang.date.oldjava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SimpleDateFormatSample {
	
	/**
	 * ~Java7
	 * 
	 */
	public static void main(String... args) {

		ln();
		pr("SimpleDateFormat");
		ln();
		
		Date now = new Date();
		
		SimpleDateFormat jpSdf = new SimpleDateFormat("yyyy'年' MM'月' dd'日' E, a KK':'mm, z ");
		pr(jpSdf.format(now));
		
		SimpleDateFormat usSdf = new SimpleDateFormat("yyyy'/' MM'/' dd'/' EEE, a KK':'mm", Locale.US);
		pr(usSdf.format(now));
		
		SimpleDateFormat parseSdf = new SimpleDateFormat("yyyy'/'MM'/'dd hh':'mm");
		try {
			pr(parseSdf.parse("2010/07/12 12:05"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void pr(Object s){
		System.out.println(s);
	}

	static void ln(){
		System.out.println("");
	}

}
