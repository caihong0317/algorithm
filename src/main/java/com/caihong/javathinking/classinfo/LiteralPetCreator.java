package com.caihong.javathinking.classinfo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiteralPetCreator extends PetCreator {
    @SuppressWarnings("unchecked")
    public static final List<Class<? extends Pet>> allTypeList= List.of(Pet.class, Dog.class, Cat.class, Bird.class);

    @Override
    public List<Class<? extends Pet>> initTypeList() {
        return allTypeList;
    }
}
