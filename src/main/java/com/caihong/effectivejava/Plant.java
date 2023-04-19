package com.caihong.effectivejava;

import java.util.*;

public class Plant {
    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

    final String name;
    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    public Set<Plant>[] partGarden(List<Plant> garden) {
        Set<Plant>[] plants = (Set<Plant>[]) new Set[LifeCycle.values().length];
        for (int i = 0; i < plants.length; i++) {
            plants[i] = new HashSet<>();
        }
        for (Plant plant : garden) {
            plants[plant.lifeCycle.ordinal()].add(plant);
        }
        return plants;
    }

    public Map<Plant.LifeCycle, Set<Plant>> partGardenForMap(List<Plant> garden) {
        Map<LifeCycle, Set<Plant>> enumMap = new EnumMap<>(LifeCycle.class);
        for (LifeCycle cycle : LifeCycle.values()) {
            enumMap.put(cycle, new HashSet<>());
        }
        for (Plant plant : garden) {
            enumMap.get(plant.lifeCycle).add(plant);
        }
        return enumMap;
    }
}
