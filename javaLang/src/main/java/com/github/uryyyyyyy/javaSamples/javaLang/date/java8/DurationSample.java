package com.github.uryyyyyyy.javaSamples.javaLang.date.java8;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DurationSample {

	/**
	 * Java8
	 * refs : http://dev.ariel-networks.com/wp/archives/4186
	 * http://acro-engineer.hatenablog.com/entry/20130213/1360691391
	 */
	public static void main(String... args) {

		ln();
		pr("ZonedDateTime Objects");
		ln();

		ZoneId jst = ZoneId.of("JST", ZoneId.SHORT_IDS);
		ZonedDateTime myTime = ZonedDateTime.of(2014, 1, 31, 10, 0, 0, 0, jst);
		ZonedDateTime deadline = ZonedDateTime.of(2014, 2, 8, 10, 0, 0, 0, jst);

		// 日数計算
		// 例: 締切りまで残り何日か?
		// 注意: 締切り日の仕様を明確にするのはコード以前の話(たとえば、1月1日締切りの意味は、当日0時なのか夜11:59つまり事実上翌日の0時なのか)
		Duration duration = Duration.between(myTime, deadline);
		pr(duration.toDays());// ? days until deadline



	}

	static void pr(Object s){
		System.out.println(s);
	}

	static void ln(){
		System.out.println("");
	}

}
