package com.github.uryyyyyyy.javaSamples.jodatime;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class DateTimeFormatSample {
	
	/**
	 * refs :http://www.mwsoft.jp/programming/java/joda_time_sample.html
	 * Joda-time v2.4
	 */
	public static void main(String[] args){
		
		ln();
		pr("DateTimeFormat");
		
		// yyyy/MM/ddでparse
		DateTime dt1 = DateTimeFormat.forPattern("yyyy/MM/dd").parseDateTime("2011/10/31");
		pr(dt1.toString());
		
		// yyyy/MM/dd HH:mm:ssでparse
		DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss")
			.parseDateTime("2011/10/31 12:25:31");
		
		// mediumDate（ロケールがja_JPの場合は、yyyy/MM/dd）
		//DateTimeFormat.mediumDate().parseDateTime("2011/10/31");

		// yyyy/MM/dd HH:mmのパースはforStyleを使ってこんな風に書けたり
		//DateTimeFormat.forStyle("MS").parseDateTime("2011/10/31 11:51");
		
	}
	
	static void pr(String s){
		System.out.println(s);
	}
	
	static void ln(){
		System.out.println("");
	}
}
