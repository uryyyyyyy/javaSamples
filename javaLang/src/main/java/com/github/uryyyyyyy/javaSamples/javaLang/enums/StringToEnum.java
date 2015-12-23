package com.github.uryyyyyyy.javaSamples.javaLang.enums;

/**
 * String型の文字列からenum型へ変換します。
 */
public class StringToEnum {

	/**
	 * メイン処理
	 * @param arg
	 * 参考：http://javatechnology.net/java/string-enum/
	 */
	public static void main(String arg[]) {
		// 文字列"AAA"からenumに変換しています。
		SampleEnum enuma1 = SampleEnum.valueOf("AAA");
		System.out.println("取得したenum型：" + enuma1.toString());

		// 文字列からenumに変換出来ない場合は例外になります。
		SampleEnum enuma2 = SampleEnum.valueOf("CCC");
	}

	public enum SampleEnum {
		AAA, BBB;
	}
}