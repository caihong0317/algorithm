package com.caihong.javathinking.multideleviry;

public enum RoShamBo2 implements Competitor<RoShamBo2> {
    Rock(OutCome.DRAW, OutCome.WIN, OutCome.LOSE),
    Scissors(OutCome.LOSE, OutCome.DRAW, OutCome.WIN),
    Paper(OutCome.WIN, OutCome.LOSE, OutCome.DRAW);
    private OutCome vsRock;
    private OutCome vsScissors;
    private OutCome vsPaper;

    RoShamBo2(OutCome vsRock, OutCome vsScissors, OutCome vsPaper) {
        this.vsRock = vsRock;
        this.vsScissors = vsScissors;
        this.vsPaper = vsPaper;
    }

    @Override
    public OutCome compete(RoShamBo2 it) {
        switch (it) {
            default:
            case Rock:
                return vsRock;
            case Paper:
                return vsPaper;
            case Scissors:
                return vsScissors;
        }
    }

    public static void main(String[] args) {
        RoShamBoUtil.play(RoShamBo2.class, 10);
    }
}
