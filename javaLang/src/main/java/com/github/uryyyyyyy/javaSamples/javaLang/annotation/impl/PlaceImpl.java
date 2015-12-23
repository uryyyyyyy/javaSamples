package com.github.uryyyyyyy.javaSamples.javaLang.annotation.impl;

import com.github.uryyyyyyy.javaSamples.javaLang.annotation.marker.PlaceAnnotation;

@PlaceAnnotation
// TYPE：クラス定義やインターフェース定義をする場所
public class PlaceImpl {

	@PlaceAnnotation
	// FIELD：フィールド（メンバー変数）定義
	protected int value;

	@PlaceAnnotation
	// CONSTRUCTOR：コンストラクター定義
	public PlaceImpl() {
	}

	@PlaceAnnotation
	// METHOD：メソッド定義
	public void メソッド() {
	}

	public int 引数ありメソッド(@PlaceAnnotation// PARAMETER：パラメーター（メソッドの引数）定義
			int param) {

		@PlaceAnnotation
		// LOCAL_VARIABLE：ローカル変数定義
		int local_var = 0;

		for (@PlaceAnnotation
		int i = 0; i < 10; i++)
			; // LOCAL_VARIABLE：ローカル変数定義[2008-12-08]

		// × メソッド呼び出しには付けられない
		System.out.println(local_var);

		// × 文には付けられない
		for (int i = 0; i < 10; i++)
			;

		// × ブロックにも付けられない
		{
			int n = 1;
			System.out.println(n);
		}

		// × returnにも当然付けられない
		return 1;
	}
}