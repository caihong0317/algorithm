package com.caihong.javathinking.classinfo;

import java.util.HashMap;

public class TypeCounter extends HashMap<Class<?>, Integer> {
    private Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object object) {
        Class<?> type = object.getClass();
        if (!baseType.isAssignableFrom(type)) {
            throw new RuntimeException("object is not ...");
        }
        countType(type);
    }

    private void countType(Class<?> type) {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superclass = type.getSuperclass();
        if (superclass != null && baseType.isAssignableFrom(superclass)) {
            countType(superclass);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        int count = 0;
        for (Entry<Class<?>, Integer> entry : entrySet()) {
            count += 1;
            builder.append(entry.getKey().getSimpleName());
            builder.append("=");
            builder.append(entry.getValue());
            if (count != size()) {
                builder.append(",");
            }
        }
        builder.append("}");
        return builder.toString();
    }

    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        LiteralPetCreator creator = new LiteralPetCreator();
        for (Pet pet : creator.creatArray(10)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
        System.out.println(counter);
    }
}