package com.github.uryyyyyyy.javaSamples.javaLang.date.oldjava;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CallenderSample {

	/**
	 * ~Java7
	 * Dateの計算とか特定の値を取得する際に用いる。
	 * 
	 */
	public static void main(String... args) {

		ln();
		pr("Calendar Objects");
		ln();

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		pr(date);


		ln();
		pr("TimeZone, Locale");
		ln();

		Calendar calUS = Calendar.getInstance(Locale.US);
		Calendar calJP = Calendar.getInstance(Locale.JAPAN);
		pr(calUS.getTime());
		pr(calJP.getTime());

		TimeZone tz = TimeZone.getTimeZone("America/New_York");
		Calendar calNY = Calendar.getInstance(tz);
		pr(calNY.getTime());

		ln();
		pr("Calendar initiate");
		ln();

		Calendar now = Calendar.getInstance();

		now.set(Calendar.YEAR, 1980);
		now.set(Calendar.HOUR_OF_DAY, 22);
		now.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		now.set(Calendar.MONTH, Calendar.JULY);
		pr(now.getTime());
		
		pr(now.get(Calendar.DAY_OF_WEEK));
		pr(now.get(Calendar.HOUR_OF_DAY));

		ln();
		pr("Calendar calculate");
		ln();

		Calendar now2 = Calendar.getInstance();
		pr(now2.getTime());

		now2.add(Calendar.DATE, 5);
		now2.add(Calendar.MONTH, -2);
		pr(now2.getTime());

		pr(now.getTime());
		pr(now2.before(now));
		
		Calendar now3 = Calendar.getInstance();
		now3.set(2014, Calendar.FEBRUARY, 1);
		pr(now3.getActualMaximum(Calendar.DATE));//28
		
		now3.set(2014, Calendar.SEPTEMBER, 1);
		pr(now3.getActualMaximum(Calendar.DATE));//30
		
		now3.set(2016, Calendar.FEBRUARY, 1);
		pr(now3.getActualMaximum(Calendar.DATE));//29

	}

	static void pr(Object s){
		System.out.println(s);
	}

	static void ln(){
		System.out.println("");
	}

}
