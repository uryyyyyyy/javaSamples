package com.github.uryyyyyyy.javaSamples.javaLang.date.java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeSample {

	/**
	 * Java8
	 * refs : http://dev.ariel-networks.com/wp/archives/4186
	 * http://acro-engineer.hatenablog.com/entry/20130213/1360691391
	 */
	public static void main(String... args) {

		ln();
		pr("LocalDateTime Objects");
		ln();

		// 日付
		LocalDate date = LocalDate.now();
		pr(date);

		// 時間
		LocalTime time = LocalTime.now();
		pr(time);

		// 日時
		LocalDateTime dt = LocalDateTime.now();
		pr(dt);

		ln();
		pr("DateTime Constructor");
		ln();

		// 年月日などを指定。秒未満は省略可
		pr(LocalDateTime.of(2012, Month.FEBRUARY, 3, 21, 30, 15));
		pr(LocalDateTime.of(2012, 2, 3, 21, 30, 15, 123));

		// 文字列を指定。秒未満は省略可
		pr(LocalDateTime.parse("2012-02-03T21:30:15.123"));

		LocalDate d = LocalDate.parse("2013-02-12");
		pr(d.plusDays(5));

		// ラベル日
		// 想定例: クリスマスの終日予定は、どのタイムゾーンのカレンダーで見てもずれない
		LocalDate xmasDay = LocalDate.of(2014, 12, 25);

		ln();
		pr("LocalDateTime caluculate");
		ln();

		// 2012/02/03 21:30:15
		LocalDateTime dateTime = LocalDateTime.of(2012, 2, 3, 21, 30, 15);

		// 3日後
		pr(dateTime.plusDays(3));

		// 100日前
		pr(dateTime.minusDays(100));

		// 30分前
		pr(dateTime.minusSeconds(30));

		// 元のインスタンスの値は・・・？
		pr(dateTime);
		
		DayOfWeek dow = dateTime.getDayOfWeek();
		pr(dow.plus(2));

	}

	static void pr(Object s){
		System.out.println(s);
	}

	static void ln(){
		System.out.println("");
	}

}
