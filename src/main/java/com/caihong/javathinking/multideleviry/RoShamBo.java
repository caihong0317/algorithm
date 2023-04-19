package com.caihong.javathinking.multideleviry;

import java.util.Random;

public class RoShamBo {
    private static final Random RANDOM = new Random(47);

    public static Item newItem() {
        Item item;
        switch (RANDOM.nextInt(3)) {
            case 0:
                item = new Paper();
                break;
            case 1:
                item = new Scissors();
                break;
            case 2:
                item = new Rock();
                break;
            default:
                item = null;
        }
        return item;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Item a = newItem();
            Item b = newItem();
            System.out.println(a + " VS " + b + ": "+a.compete(b));
        }
    }
}
