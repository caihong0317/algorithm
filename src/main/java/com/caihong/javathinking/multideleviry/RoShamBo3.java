package com.caihong.javathinking.multideleviry;

import java.util.EnumMap;

public enum RoShamBo3 implements Competitor<RoShamBo3> {
    ROCK, SCISSORS, PAPER;
    static EnumMap<RoShamBo3, EnumMap<RoShamBo3, OutCome>> table = new EnumMap<>(RoShamBo3.class);

    static {
        for (RoShamBo3 value : RoShamBo3.values()) {
            table.put(value, new EnumMap<>(RoShamBo3.class));
        }
        initRow(ROCK, OutCome.DRAW, OutCome.LOSE, OutCome.WIN);
        initRow(SCISSORS, OutCome.LOSE, OutCome.DRAW, OutCome.WIN);
        initRow(PAPER, OutCome.WIN, OutCome.LOSE, OutCome.DRAW);
    }

    private static void initRow(RoShamBo3 it, OutCome vsRock, OutCome vsScissors, OutCome vsPaper) {
        EnumMap<RoShamBo3, OutCome> row = table.get(it);
        row.put(ROCK, vsRock);
        row.put(SCISSORS, vsScissors);
        row.put(PAPER, vsPaper);
    }

    @Override
    public OutCome compete(RoShamBo3 it) {
        return table.get(this).get(it);
    }

    public static void main(String[] args) {
        RoShamBoUtil.play(RoShamBo3.class, 10);
    }
}
