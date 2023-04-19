package com.caihong.javathinking.classinfo;

import java.util.HashMap;

public class PetCount {
    private static class PetCounter extends HashMap<String, Integer> {
        public void count(String typeName) {
            Integer quantity = get(typeName);
            if (quantity == null) {
                put(typeName, 1);
            } else {
                put(typeName, quantity + 1);
            }
        }
    }

    public static void countPet(PetCreator creator, int size) {
        if (size <= 0) {
            return;
        }
        PetCounter counter = new PetCounter();
        for (Pet pet : creator.creatList(size)) {
            if (pet instanceof Pet) {
                counter.count(Pet.class.getSimpleName());
            }
            if (pet instanceof Dog) {
                counter.count(Dog.class.getSimpleName());
            }
            if (pet instanceof Cat) {
                counter.count(Cat.class.getSimpleName());
            }
            if (pet instanceof Bird) {
                counter.count(Bird.class.getSimpleName());
            }
        }
        System.out.println(counter);
    }

    public static void main(String[] args) {
        countPet(new ForNameCreator(), 10);
    }
}
