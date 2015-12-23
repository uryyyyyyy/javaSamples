package com.github.uryyyyyyy.javaSamples.jodatime;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.Period;

public class IntervalSample {
	
	/**
	 * refs :http://shinsuke789.hatenablog.jp/entry/2013/08/06/195436
	 * Joda-time v2.4
	 */
	public static void main(String[] args){
		
		ln();
		pr("Interval");
		ln();
		
		// 日時と期間の定義１
		DateTime start1 = new DateTime("2013-08-01T12:30:30.100");
		DateTime end1 = new DateTime("2013-08-10T14:30:50.300");
		Interval interval1 = new Interval(start1, end1);
		pr(interval1.toString());
		 
		// 日時と期間の定義2
		DateTime start2 = new DateTime("2013-08-10T12:30:30.100");
		DateTime end2 = new DateTime("2013-08-20T14:30:50.300");
		Interval interval2 = new Interval(start2, end2);
		pr(interval2.toString());
		 
		// ２つの期間が連続するか？ => true 
		// なんだけど、なぜかfalseになる。。。バグってる？
		pr(interval1.abuts(interval2));
		// ２つの期間の差を期間で取得
		Interval interval3 = interval1.gap(interval2);
		pr(interval3);
		// ２つの期間の重なった期間を取得
		Interval interval4 = interval1.overlap(interval2);
		pr(interval4.toString());

		// 期間内に指定の日付が含まれるか => true
		pr(interval2.contains(new DateTime("2013-08-15")));
		// 期間内に指定の期間が含まれるか => true
		pr(interval1.contains(interval2));
		// 期間内に現在が含まれているか => false
		pr(interval1.containsNow());

		// Durationに変換
		Duration d = interval1.toDuration();
		// Periodに変換
		Period p = interval1.toPeriod();
		
	}
	
	static void pr(Object s){
		System.out.println(s);
	}
	
	static void ln(){
		System.out.println("");
	}
}
