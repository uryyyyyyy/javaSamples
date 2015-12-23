package com.github.uryyyyyyy.javaSamples.jodatime;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;

public class DurationSample {
	
	/**
	 * refs :http://www.mwsoft.jp/programming/java/joda_time_sample.html
	 * http://shinsuke789.hatenablog.jp/entry/2013/08/06/195436
	 * Joda-time v2.4
	 */
	public static void main(String[] args){
		
		ln();
		pr("Duration");
		
		// 2010/12/21 10:00:00
		DateTime dt1 = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss").parseDateTime("2011/12/21 10:00:00");
		// 2011/08/13 15:32:51
		DateTime dt2 = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss").parseDateTime("2011/08/13 15:32:51");

		// 上の2つのDateTimeのDuration
		Duration d = new Duration(dt1, dt2);

		// 日の差分
		pr(d.getStandardDays());
		  //=> -129

		// 時の差分
		pr(d.getStandardHours());
		  //=> -3114

		// 分の差分
		pr(d.getStandardMinutes());
		  //=> -186867

		// 秒の差分
		pr(d.getStandardSeconds());
		  //=> -11212029
		
	}
	
	static void pr(Object s){
		System.out.println(s);
	}
	
	static void ln(){
		System.out.println("");
	}
}
