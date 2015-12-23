package com.github.uryyyyyyy.javaSamples.gsCollection;

import com.gs.collections.impl.factory.Lists;


public class Main {

    public static void main(String args[]){
        Lists.immutable
                .of("one", "two", "three", "four")
                .select(s -> s.contains("o"))
                .collect(s -> "[" + s + "]")
                .each(System.out::println);
    }
}
