package com.github.uryyyyyyy.javaSamples.javaLang.date.java8;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.JapaneseDate;
import java.time.chrono.JapaneseEra;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class JapaneseDateSample {

	/**
	 * Java8
	 * refs : http://dev.ariel-networks.com/wp/archives/4186
	 * http://acro-engineer.hatenablog.com/entry/20130213/1360691391
	 */
	public static void main(String... args) {

		ln();
		pr("JapaneseDate Objects");
		ln();

		Locale jpLocale = new Locale("ja", "JP", "JP");
		Chronology wareki = Chronology.ofLocale(jpLocale);
		Chronology wareki2 = Chronology.of("Japanese"); // 上記2行の代替例
		pr(wareki);


		// ZonedDateTime(内部時刻)から和暦出力
		// 想定例: 利用者が和暦での日時表示を期待
		ZonedDateTime myTime = ZonedDateTime.of(1989, 1, 7, 10, 0, 0, 0, ZoneId.of("JST", ZoneId.SHORT_IDS));
		ChronoLocalDate heisei = wareki.date(myTime);
		// "Heisei"=>"平成"の文字列変換は自前実装が必要
		pr(heisei.getEra());
		pr(heisei.get(ChronoField.YEAR_OF_ERA));
		pr(heisei.get(ChronoField.MONTH_OF_YEAR));
		pr(heisei.get(ChronoField.DAY_OF_MONTH));

		// 和暦年号(H26)から西暦年号(2014年)へ変換
		// 想定例: 利用者が和暦で日時を入力 
		String WAREKI_HEISEI = "Heisei"; // "Heisei"はハードコード
		JapaneseEra jpEra = JapaneseEra.valueOf(WAREKI_HEISEI);
		ChronoLocalDate heisei2 = wareki.date(jpEra, 26, 3, 15);
		pr("A.D. " + heisei2.get(ChronoField.YEAR)); //=> 2014
		
		JapaneseDate jDate = JapaneseDate.now();
		pr(jDate);
		
		ln();
		pr("Tips");
		ln();
		
		
		ZonedDateTime myTime2 = ZonedDateTime.of(1873, 1, 31, 10, 0, 0, 0, ZoneId.of("JST", ZoneId.SHORT_IDS));
		ChronoLocalDate meiji6 = wareki.date(myTime2);
		pr(meiji6.getEra());
		pr(meiji6.get(ChronoField.MONTH_OF_YEAR));
		
		// JapaneseDate before Meiji 6 is not supported
//		ZonedDateTime myTime3 = ZonedDateTime.of(1872, 1, 31, 10, 0, 0, 0, ZoneId.of("JST", ZoneId.SHORT_IDS));
//		ChronoLocalDate meiji5 = wareki.date(myTime3);
//		pr(meiji5.getEra());
//		pr(meiji5.get(ChronoField.MONTH_OF_YEAR));
		
		ZonedDateTime myTime4 = ZonedDateTime.of(1989, 1, 7, 10, 0, 0, 0, ZoneId.of("JST", ZoneId.SHORT_IDS));
		ChronoLocalDate showa = wareki.date(myTime4);
		pr(showa.getEra());
		pr(showa.get(ChronoField.MONTH_OF_YEAR));
		
		//一日違いで元号が変わる。
		ZonedDateTime myTime5 = ZonedDateTime.of(1989, 1, 8, 10, 0, 0, 0, ZoneId.of("JST", ZoneId.SHORT_IDS));
		ChronoLocalDate heisei1 = wareki.date(myTime5);
		pr(heisei1.getEra());
		pr(heisei1.get(ChronoField.MONTH_OF_YEAR));
		
	}

	static void pr(Object s){
		System.out.println(s);
	}

	static void ln(){
		System.out.println("");
	}

}
