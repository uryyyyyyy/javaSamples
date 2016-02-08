package com.github.uryyyyyyy.javaSamples.kryo.model;

public class MyDto2 {

    public final String fpubStr;
    public final long fpubLong;
    public final String fpriStr;
    public final long fpriLong;
    public String pubStr;
    public long pubLong;
    public String priStr;
    public long priLong;

    public MyDto2(String fpubStr, long fpubLong, String fpriStr, long fpriLong, String pubStr, long pubLong, String priStr, long priLong) {
        this.fpubStr = fpubStr;
        this.fpubLong = fpubLong;
        this.fpriStr = fpriStr;
        this.fpriLong = fpriLong;
        this.pubStr = pubStr;
        this.pubLong = pubLong;
        this.priStr = priStr;
        this.priLong = priLong;
    }
}
