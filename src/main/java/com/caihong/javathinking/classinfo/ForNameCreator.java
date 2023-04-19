package com.caihong.javathinking.classinfo;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static final String[] TYPE_NAMES = {"com.caihong.javathinking.classinfo.Pet",
        "com.caihong.javathinking.classinfo.Dog", "com.caihong.javathinking.classinfo.Cat",
        "com.caihong.javathinking.classinfo.Bird"};

    private static List<Class<? extends Pet>> types = new ArrayList<>(TYPE_NAMES.length);

    static {
        load();
    }

    @SuppressWarnings("unchecked")
    private static void load() {
        for (String typeName : TYPE_NAMES) {
            try {
                types.add((Class<? extends Pet>) Class.forName(typeName));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Class<? extends Pet>> initTypeList() {
        return types;
    }
}
