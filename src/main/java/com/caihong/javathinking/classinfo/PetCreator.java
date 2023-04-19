package com.caihong.javathinking.classinfo;

import java.util.*;

public abstract class PetCreator {
    private static final Random RANDOM = new Random(47);
    private List<Class<? extends Pet>> typeList = initTypeList();

    public abstract List<Class<? extends Pet>> initTypeList();

    public Pet randomPet() {
        int i = RANDOM.nextInt(typeList.size());
        try {
            return typeList.get(i).newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException();
        }
    }

    public Pet[] creatArray(int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomPet();
        }
        return result;
    }

    public List<Pet> creatList(int size) {
        return new ArrayList<>(Arrays.asList(creatArray(size)));
    }
}
