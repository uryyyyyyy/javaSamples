package com.github.uryyyyyyy.javaSamples.rxJava;

import rx.Observable;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String args[]){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Observable.from(list)
                .filter(i -> i < 4)
                .map(i -> i * 5)
                .toList().toBlocking().forEach(System.out::println);
    }
}
