package com.caihong.ApiLearn;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public interface MyComparator<T> extends Comparator<T> {
    int compare(T o1, T o2);

    boolean equals(Object obj);

    default MyComparator<T> reserved() {
        return (MyComparator<T>) Collections.reverseOrder(this);
    }

    default Comparator<T> thenComparing(Comparator<? super T> other) {
        Objects.requireNonNull(other);
        return (Comparator<T> & Serializable) (o1, o2) -> {
            int res = compare(o1, o2);
            return res != 0 ? res : other.compare(o1, o2);
        };
    }

    // 与上面同效果
    default Comparator<T> thenComparing1(MyComparator<? super T> other) {
        Objects.requireNonNull(other);
        return new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                int res = compare(o1, o2);
                return res != 0 ? res : other.compare(o1, o2);
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        };
    }

    public static <T extends Comparator<? super T>> Comparator<T> reverseOrder() {
        return Collections.reverseOrder();
    }

    public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        return (Comparator<T>) MyComparators.NaturalOrderComparator.INSTANCE;
    }

}
