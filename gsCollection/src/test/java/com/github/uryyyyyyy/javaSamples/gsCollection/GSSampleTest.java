package com.github.uryyyyyyy.javaSamples.gsCollection;

import com.gs.collections.api.LazyIterable;
import com.gs.collections.api.RichIterable;
import com.gs.collections.api.list.ImmutableList;
import com.gs.collections.api.partition.list.PartitionMutableList;
import com.gs.collections.api.tuple.Pair;
import com.gs.collections.impl.block.factory.Procedures;
import com.gs.collections.impl.factory.Lists;
import com.gs.collections.impl.list.primitive.IntInterval;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GSSampleTest {

    @Test
    public void testSelect() {
        List<String> list = Lists.mutable
                .of("hoge", "fuga", "piyo")
                .select(s -> s.contains("g"));

        System.out.println(list);
    }

    @Test
    public void testReject() {
        List<String> list = Lists.mutable
                .of("hoge", "fuga", "piyo")
                .reject(s -> s.contains("g"));

        System.out.println(list);
    }

    @Test
    public void testPartition() {
        PartitionMutableList<String> list = Lists.mutable
                .of("hoge", "fuga", "piyo")
                .partition(s -> s.contains("g"));

        System.out.println(list.getSelected());
        System.out.println(list.getRejected());
    }

    @Test
    public void testNotLazy() {
        Lists.mutable
                .of("one", "two", "three")
                .tap(s -> System.out.println("select : " + s))
                .select(s -> s.contains("t"))
                .tap(s -> System.out.println("collect : " + s))
                .collect(s -> s.length())
                .each(l -> System.out.println("each : " + l));
    }

    @Test
    public void testLazy() {
        Lists.mutable
                .of("one", "two", "three")
                .asLazy()
                .tap(s -> System.out.println("select : " + s))
                .select(s -> s.contains("t"))
                .tap(s -> System.out.println("collect : " + s))
                .collect(s -> s.length())
                .each(l -> System.out.println("each : " + l));
    }

    @Test
    public void testMakeString() {
        RichIterable<Integer> ite = Lists.mutable.of(1, 2, 3, 4);

        System.out.println(ite.makeString());
        System.out.println(ite.makeString(" : "));
        System.out.println(ite.makeString("[", ", ", "]"));
    }

    @Test
    public void testZip() {
        List<Integer> l = IntInterval.fromTo(1, 100).asLazy().collect(v -> v).toList();
        List<Pair<String, Integer>> list = Lists.mutable
                .of("one", "two", "three", "four")
                .zip(l);
        System.out.println(list);
    }

    @Test
    public void testReusable() {
        //Stream API
        try {
            Stream<Integer> stream = Lists.mutable.with(1, 2, 3).stream();
            System.out.println(stream.mapToInt(i -> i).min().getAsInt());
            System.out.println(stream.mapToInt(i -> i).max().getAsInt());
        }catch(IllegalStateException e){
            System.out.println("cannot reuse");
        }

        //GS collections
        LazyIterable<Integer> lazy = Lists.mutable.with(1, 2, 3).asLazy();
        System.out.println(lazy.collectInt(i -> i).min());
        System.out.println(lazy.collectInt(i -> i).max());
        System.out.println("reusable");
    }

    @Test
    public void testExceptionHandling() {
        //Stream API
        Appendable appendable = new StringBuilder();
        List<String> jdkList = Collections.singletonList("one");
        jdkList.forEach(each -> {
            try {
                appendable.append(each);
            }catch(IOException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(appendable.toString());

        //GS collections
        Appendable appendable2 = new StringBuilder();
        ImmutableList<String> eclipseList = Lists.immutable.with("one");
        eclipseList.each(Procedures.throwing(appendable2::append));
        System.out.println(appendable2.toString());
    }

}