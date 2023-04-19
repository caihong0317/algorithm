package com.caihong.javathinking.multideleviry;

public class Rock implements Item {
    @Override
    public OutCome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public OutCome eval(Paper paper) {
        return OutCome.LOSE;
    }

    @Override
    public OutCome eval(Scissors scissors) {
        return OutCome.WIN;
    }

    @Override
    public OutCome eval(Rock rock) {
        return OutCome.DRAW;
    }

    @Override
    public String toString() {
        return "Rock";
    }
}
