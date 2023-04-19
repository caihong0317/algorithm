package com.caihong.javathinking.multideleviry;

public interface Item {
    OutCome compete(Item item);
    OutCome eval(Paper paper);
    OutCome eval(Scissors scissors);
    OutCome eval(Rock rock);
}
