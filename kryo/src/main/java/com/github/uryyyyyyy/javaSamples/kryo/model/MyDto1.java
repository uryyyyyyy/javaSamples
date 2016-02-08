package com.github.uryyyyyyy.javaSamples.kryo.model;

public class MyDto1 {
    public final String fpubStr;
    public final long fpubLong;

    public MyDto1(){
        this.fpubStr = "hell";
        this.fpubLong = 4989;
    }

    public MyDto1(String fpubStr, long fpubLong) {
        this.fpubStr = fpubStr;
        this.fpubLong = fpubLong;
    }
}
