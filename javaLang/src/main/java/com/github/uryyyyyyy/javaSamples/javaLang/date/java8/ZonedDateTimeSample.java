package com.github.uryyyyyyy.javaSamples.javaLang.date.java8;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class ZonedDateTimeSample {

	/**
	 * Java8
	 * refs : http://dev.ariel-networks.com/wp/archives/4186
	 * http://acro-engineer.hatenablog.com/entry/20130213/1360691391
	 */
	public static void main(String... args) {

		ln();
		pr("ZonedDateTime Objects");
		ln();

		ZonedDateTime znow = ZonedDateTime.now();
		pr(znow);


		ZoneId jst = ZoneId.of("Asia/Tokyo");
		pr(jst);
		ZoneId est = ZoneId.of("America/New_York");
		pr(est);

		ZoneOffset zOffset = znow.getOffset();
		pr(zOffset);

		// 入力数値からZonedDateTime(内部時刻)
		// 想定例: 利用者は日本タイムゾーンで日時を入力 
		ZonedDateTime myTime = ZonedDateTime.of(2014, 1, 31, 10/*hour*/, 0/*min*/, 0/*sec*/, 0/*nanosec*/, jst);
		System.out.println(myTime);

		// JST時刻からEST時刻に変換(Instantとしては同時刻)
		// 想定例: 日本のカレンダーで作った予定を米国のカレンダーで表示
		ZonedDateTime ustime = myTime.withZoneSameInstant(est);
		pr(ustime);

		ln();
		pr("ZonedDateTime each value");
		ln();

		pr(myTime);
		pr(myTime.getYear());
		pr(myTime.getMonthValue());
		pr(myTime.getDayOfMonth());
		pr(myTime.getDayOfWeek());
		pr(myTime.getOffset());
		pr(myTime.getChronology());
		pr(myTime.getZone());

		ln();
		pr("ZonedDateTime <-> java.util.Date");
		ln();

		// 旧API(java.util.Date)との変換
		// java.util.Date => Date/Time API
		Date now = new Date();
		ZonedDateTime ztime = ZonedDateTime.ofInstant(now.toInstant(), jst);
		ZonedDateTime ztime2 = now.toInstant().atZone(jst);
		pr(ztime);

		// Date/Time API => java.util.Date
		Date dateNow = Date.from(Instant.from(ztime));
		Date dateNow2 = Date.from(ztime.toInstant());
		pr(dateNow);

		ln();
		pr("ZonedDateTime calculate");
		ln();

		pr(znow);
		pr(znow.plusDays(7));
		pr(znow.plusWeeks(2));

		// ZonedDateTimeを使う日付計算
		// 単純な計算はplusMonthsやminusMonthsなどのメソッドを使う
		// 少し複雑な計算はTemporalAdjustersを使う
		// 例: 2014.1.31の1ヶ月後の最初の土曜日は? => 2014.3.1
		ZonedDateTime deadline = myTime.plusMonths(1).with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		pr(deadline);

		// 時刻の比較
		// 例: 締切り前かの判定など
		// (Durationを使っても同じようにできる)
		if (myTime.compareTo(deadline) < 0) {
			System.out.println("before deadline");
		}

	}

	static void pr(Object s){
		System.out.println(s);
	}

	static void ln(){
		System.out.println("");
	}

}
