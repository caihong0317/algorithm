package com.caihong.javathinking.multideleviry;

public interface Competitor<T extends Competitor<T>> {
    OutCome compete(T competitor);
}
