package com.github.uryyyyyyy.javaSamples.javaLang.annotation.marker;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)//コンパイルすると、classファイル内にはそのアノテーションの情報は残らない。
								//Lombokとかの自動生成ライブラリで使われるかも。
//@Retention(RetentionPolicy.CLASS) コンパイルしたclassファイル内にそのアノテーションの情報が保持されるが、実行時には読み込まれない。
								//classファイルに対して何か解析をする系のツールで使っている様子。
//@Retention(RetentionPolicy.RUNTIME) 実行する際にもJavaVMにそのアノテーションの情報が読み込まれる。リフレクションを用いてその情報を取得することが出来る。
								//JUnitで使われてる。同一プロジェクトに自分で書いたJavaコードとかもこれを使うことになると思われる。
@interface ScopeAnnotation {
}