package com.caihong.javathinking.multideleviry;

public class Paper implements Item {

    @Override
    public OutCome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public OutCome eval(Paper paper) {
        return OutCome.DRAW;
    }

    @Override
    public OutCome eval(Scissors scissors) {
        return OutCome.LOSE;
    }

    @Override
    public OutCome eval(Rock rock) {
        return OutCome.WIN;
    }

    @Override
    public String toString() {
        return "Paper";
    }
}
