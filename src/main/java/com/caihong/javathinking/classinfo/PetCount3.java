package com.caihong.javathinking.classinfo;

import java.util.HashMap;
import java.util.List;

public class PetCount3 {
    private static class PetCounter extends HashMap<Class<? extends Pet>, Integer> {
        public PetCounter(List<Class<? extends Pet>> typeList) {
            for (Class<? extends Pet> aClass : typeList) {
                put(aClass, 0);
            }
        }

        public void count(Pet pet) {
            for (Entry<Class<? extends Pet>, Integer> entry : entrySet()) {
                if (entry.getKey().isInstance(pet)) {
                    put(entry.getKey(), entry.getValue() + 1);
                    // 加不加有区别
                    //break;
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{");
            int count = 0;
            for (Entry<Class<? extends Pet>, Integer> entry : entrySet()) {
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
    }

    public static void main(String[] args) {
        PetCounter counter = new PetCounter(LiteralPetCreator.allTypeList);
        Pet[] pets = new LiteralPetCreator().creatArray(10);
        for (Pet pet : pets) {
            counter.count(pet);
        }
        System.out.println(counter);
    }
}