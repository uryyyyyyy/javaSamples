package com.github.uryyyyyyy.javaSamples.jodatime;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeSample {
	
	/**
	 * refs :http://www.mwsoft.jp/programming/java/joda_time_sample.html
	 * http://shinsuke789.hatenablog.jp/entry/2013/08/05/120042
	 * Joda-time v2.4
	 */
	public static void main(String[] args){
		
		pr("DateTime initialize");
		ln();
		
		// 引数なしの場合は現在日時で初期化される
		DateTime dt = new DateTime();

		// java.util.Dateやjava.util.Calendarを引数にとって初期化することも可能
		Date date = new Date();
		DateTime dt2 = new DateTime(date);

		// 年月日時分秒を指定して初期化（バージョン2.0で追加）
		pr(new DateTime(2011, 10, 23, 3, 50, 0));
		pr(new DateTime(2011, 10, 23, 3, 50, 0, DateTimeZone.forID("America/New_York")));
		
		pr(new DateTime(DateTimeZone.forID("Asia/Tokyo")));
		//=>2014-08-23T20:08:31.196+09:00
		
		pr(new DateTime(DateTimeZone.forID("America/New_York")));
		//=>2014-08-23T07:08:31.197-04:00
		//東京との誤差13時間
		
		
		ln();
		pr("convert to DateTime");
		ln();
		
		// Date型から
		DateTime dt3 = new DateTime(new Date());
		
		// Calendar型から
		DateTime dt4 = new DateTime(Calendar.getInstance());

		// ISO日付文字列から
		DateTime dt5 = new DateTime("2013-08-01");
		DateTime dt6 = new DateTime("2013-08-01T12:30:50");
		
		// ミリ秒から
		Date d = new Date();
		DateTime dt7 = new DateTime(d.getTime());
		
		ln();
		pr("convert from DateTime");
		ln();
		
		// Calendarに変換
		Calendar calendar = dt.toCalendar(null);

		// Dateに変換
		Date date2 = dt.toDate();

		// DateMidnightに変換
		DateMidnight dateMidnight = dt.toDateMidnight();

		// LocalDateに変換
		LocalDate localDate = dt.toLocalDate();

		// LocalDateTimeに変換
		LocalDateTime localDateTime = dt.toLocalDateTime();

		// LocalTimeに変換
		LocalTime localTime = dt.toLocalTime();
		
		ln();
		pr("toString method");
		ln();
		
		pr(dt);
		//=> 2014-08-23T19:09:41.092+09:00
		//最後のは標準時間との誤差

		pr(dt.toString("yyyy/MM/dd"));
		//=> 2014/08/23

		// パターンと一緒にLocaleも渡せる
		pr(dt.toString("yyyy-MM-dd-hh-mm-ss E", Locale.JAPAN));
		//=> 2014-08-23-07-17-27 土
		pr(dt.toString("yyyy-MM-dd-hh-mm-ss E", Locale.US));
		//=> 2014-08-23-07-17-27 Sat
		
		ln();
		pr("DateTime calculate methods");
		ln();

		// 年だけ2005にして他はdtが持つ時間
		pr(dt.withYear(2005));
		//=> 2005-12-21T23:23:33.554+09:00

		// 月だけ10月にして他はdtが持つ時間
		pr(dt.withMonthOfYear(10));
		//=> 2011-10-21T23:23:33.554+09:00

		// withDateで年月日をまとめて設定
		pr(dt.withDate(2000, 3, 10));
		//=> 2000-03-10T23:23:33.554+09:00

		// withTimeで時分秒ミリ秒をまとめて設定
		pr(dt.withTime(5, 10, 20, 0));
		//=> 2011-12-21T05:10:20.000+09:00
		
		// plusDaysで10日間足してみる
		pr(dt.plusDays(10).toString("yyyy/MM/dd HH:mm"));
		  //=> 2011/12/31 23:19

		// plusHoursで10時間足してみる
		pr(dt.plusHours(10).toString("yyyy/MM/dd HH:mm"));
		//=> 2011/12/22 09:19

		// plusHoursに負の数を入れて10時間引いてみる
		pr(dt.plusHours(-10).toString("yyyy/MM/dd HH:mm"));
		//=> 2011/12/31 13:19

		// minusHoursでも同じことができる
		pr(dt.minusHours(10).toString("yyyy/MM/dd HH:mm"));
		  //=> 2011/12/31 13:19

		// addWeekで来週を取れたりもする
		pr(dt.plusWeeks(1));
		//=> 2011/12/29 13:19

		// 1月31日の1ヶ月後は2月28日になるらしい
		DateTime jan31 = new DateTime(2011, 01, 31, 0, 0);
		pr(jan31.plusMonths(1));
		//=> 2011-02-28T00:00:00.000+09:00

		// minusYearsで1000年前に戻ってみる
		pr(dt.minusYears(1000).toString("yyyy/MM/dd HH:mm"));
		//=> 1011/12/21 13:19

		// minusYearsで紀元前に行ってみる
		pr(dt.minusYears(3000).toString("yyyy/MM/dd HH:mm"));
		//=> -0989/12/21 14:24

		// 前月の1日とかはwithと組み合わせてこんな感じで取ってもいいのかな
		pr(dt.minusMonths(1).withDayOfMonth(1));
		//=> 2011-11-01T23:52:57.917+09:00
		
		ln();
		pr("DateTime predicate methods");
		ln();
		
		DateTime dtL = new DateTime().withHourOfDay(3);
		  //=> 2011-12-21T03:47:48
		DateTime dtR = new DateTime().withHourOfDay(5);
		  //=> 2011-12-21T05:47:48

		// dt1（3時）はdt2（5時）より未来か？
		pr(dtL.isAfter(dtR));
		//=> false

		// dt1（3時）はdt2（5時）より過去か？
		pr(dtL.isBefore(dtR));
		  //=> true
		
		// dt1（3時）とdt2（5時）は同じ時刻か？
		pr(dtL.isEqual(dtR));
		  //=> false

		// LocalDateかDateMidnightに変換すれば同日かどうか判定できたり
		pr(dtL.toDateMidnight().isEqual(dtR.toDateMidnight()));
		  //=> true
		
		// isAfterNowで現在より未来かが判定できる
		pr(dtL.isAfterNow());
		  //=> false

		// isBeforeNowもある
		pr(dtL.isBeforeNow());
		  //=> true
		
		ln();
		pr("DateTime Property methods");
		ln();

		// 年で切り捨ててみる
		pr(dt.year().roundFloorCopy());
		  //=> 2011/01/01 00:00:00

		// 年で切り上げてみる
		pr(dt.year().roundCeilingCopy());
		  //=> 2012/01/01 00:00:00

		// 四捨五入っぽいのもある（今年の場合は7/2の11:59:59までは切り捨てだった）
		pr(new DateTime(2011, 7, 2, 0, 0).year().roundHalfEvenCopy());
		  //=> 2011/01/01 00:00:00
		pr(new DateTime(2011, 7, 3, 0, 0).year().roundHalfEvenCopy());
		  //=> 2012/01/01 00:00:00
		
		// 月
		pr(dt.monthOfYear().roundCeilingCopy());

		// 日
		pr(dt.dayOfMonth().roundFloorCopy());

		// 時
		pr(dt.hourOfDay().roundHalfEvenCopy());

		// 分
		pr(dt.minuteOfHour().roundCeilingCopy());

		// 秒
		pr(dt.secondOfMinute().roundHalfCeilingCopy());
		
		ln();
		pr("DateTime etc...");
		ln();
		
		// うるう年？
		pr(dt.year().isLeap());
		  //=> false

		// その月の末日
		pr(dt.dayOfMonth().withMaximumValue());
		  //=> 2011-12-31T12:02:20.192+09:00

		// 5桁の年とかも普通に扱えるので、1万年問題も大丈夫
		DateTimeFormat.forPattern("yyyy/MM/dd HH:mm").parseDateTime("12011/12/22 23:39");
		  //=> 12011-12-29T23:39:00.000+09:00

		// じゃ、3000億年問題はどうだろうと思って調べたら、なぜか292278977年（約3億）で落ちた
		//DateTimeFormat.forPattern("yyyy/MM/dd HH:mm").parseDateTime("292278977/02/01 00:00");
		  //=> Cannot parse "292278977/02/01 00:00": Illegal instant due to time zone offset transition (Asia/Tokyo)
		
	}
	
	static void pr(Object s){
		System.out.println(s);
	}
	
	static void ln(){
		System.out.println("");
	}
}
