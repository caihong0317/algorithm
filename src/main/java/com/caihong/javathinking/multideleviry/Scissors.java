package com.caihong.javathinking.multideleviry;

public class Scissors implements Item {
    @Override
    public OutCome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public OutCome eval(Paper paper) {
        return OutCome.WIN;
    }

    @Override
    public OutCome eval(Scissors scissors) {
        return OutCome.DRAW;
    }

    @Override
    public OutCome eval(Rock rock) {
        return OutCome.LOSE;
    }

    @Override
    public String toString() {
        return "Scissors";
    }
}
