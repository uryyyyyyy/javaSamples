package com.github.uryyyyyyy.javaSamples.javaLang.annotation.marker;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target( { ElementType.TYPE, ElementType.FIELD, ElementType.CONSTRUCTOR,
	ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE })
	//フィールドにだけ付けられる指定
public @interface PlaceAnnotation {
}
