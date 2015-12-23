package com.github.uryyyyyyy.javaSamples.javaLang.enums;

public class IntToEnum {
	/**
	 * メイン処理
	 * 参考：http://javatechnology.net/java/int-enum/
	 */
	public static void main(String arg[]) {
		SampleEnum enum1 = SampleEnum.getEnum(1);
		System.out.println("取得したenum：" + enum1);
		
		SampleEnum enum2 = SampleEnum.getEnum(3);
		System.out.println("取得したenum：" + enum2);
	}

	public enum SampleEnum {

		AAA(1),
		BBB(2);

		private int name;

		public int getName() {
			return name;
		}

		private SampleEnum (int name) {
			this.name = name;
		}

		public static SampleEnum getEnum(int num) {
			// enum型全てを取得します。
			SampleEnum[] enumArray = SampleEnum.values();

			// 取得出来たenum型分ループします。
			for(SampleEnum enumInt : enumArray) {
				// 引数intとenum型の変数を比較します。
				if (num == enumInt.name){
					return enumInt;
				}
			}
			//例外を吐くでもいいかも？
			return null;
		}
	}
}