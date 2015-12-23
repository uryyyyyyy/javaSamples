package com.github.uryyyyyyy.javaSamples.javaLang.annotation.marker;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) @Inherited
public @interface InheritedAnnotation { String value(); }