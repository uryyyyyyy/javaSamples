package com.github.uryyyyyyy.javaSamples.kryo.model;

public class MyDto3 {
    private String fpubStr;
    private long fpubLong;

    public MyDto3(String fpubStr, long fpubLong) {
        this.fpubStr = fpubStr;
        this.fpubLong = fpubLong;
    }

    public MyDto3(){}

    public long getFpubLong() {
        return fpubLong;
    }

    public void setFpubLong(long fpubLong) {
        this.fpubLong = fpubLong;
    }

    public String getFpubStr() {
        return fpubStr;
    }

    public void setFpubStr(String fpubStr) {
        this.fpubStr = fpubStr;
    }
}
