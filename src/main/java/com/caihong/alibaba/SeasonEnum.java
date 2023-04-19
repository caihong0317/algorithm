package com.caihong.alibaba;

public enum SeasonEnum {
    SPRING(1, "a"),
    SUMMER(2),
    AUTUMN(3),
    WINTER(4);

    private int season;
    private String name;

    //默认为private
    SeasonEnum(int season) {
        this.season = season;
    }

    SeasonEnum(int season, String name) {
        this.season = season;
        this.name = name();
    }

    public int getSeason() {
        return season;
    }

    // 不需要
    public void setSeason(int season) {
        this.season = season;
    }
}
