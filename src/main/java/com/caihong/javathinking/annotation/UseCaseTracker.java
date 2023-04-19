package com.caihong.javathinking.annotation;

import java.lang.reflect.Method;
import java.util.List;

public class UseCaseTracker {
    public static void trackUseCase(List<Integer> useCaseIds, Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            UseCase useCase = method.getAnnotation(UseCase.class);
            if (useCase != null) {
                int id = useCase.id();
                System.out.println("Find: id" + id);
                useCaseIds.remove(id);
            }
        }
        for (Integer id : useCaseIds) {
            System.out.println("not Find: id" + id);
        }
    }
}
