package com.github.uryyyyyyy.javaSamples.jodatime;

import org.joda.time.DateTime;
import org.joda.time.Period;

public class PeriodSample {
	
	/**
	 * refs :http://shinsuke789.hatenablog.jp/entry/2013/08/06/195436
	 * Joda-time v2.4
	 */
	public static void main(String[] args){
		
		ln();
		pr("Period");
		ln();
		
		// 日時の定義
		DateTime start = new DateTime("2013-08-01T12:30:50.666");
		DateTime end = new DateTime("2014-09-08T23:40:00.999");
		 
		// Periodで期間を定義
		Period period = new Period(start, end);
		 
		// --- 期間の差を取得
		// 年 => 1
		pr(period.getYears());
		
		// 月 => 1
		pr(period.getMonths());
		
		// 週 => 1
		pr(period.getWeeks());
		
		// 日（1周間内の日数） => 0
		pr(period.getDays());
		
		// 時 => 11
		pr(period.getHours());
		
		// 分 => 9
		pr(period.getMinutes());
		
		// 秒 => 10
		pr(period.getSeconds());
		
		// ミリ秒 => 333
		pr(period.getMillis());
		
	}
	
	static void pr(Object s){
		System.out.println(s);
	}
	
	static void ln(){
		System.out.println("");
	}
}
