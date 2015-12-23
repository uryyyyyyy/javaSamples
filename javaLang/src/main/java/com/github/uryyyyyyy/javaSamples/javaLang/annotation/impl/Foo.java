package com.github.uryyyyyyy.javaSamples.javaLang.annotation.impl;

import com.github.uryyyyyyy.javaSamples.javaLang.annotation.marker.InheritedAnnotation;

public interface Foo{
    @InheritedAnnotation("Foo") void doStuff();
}