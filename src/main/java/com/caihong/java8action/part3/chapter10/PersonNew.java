package com.caihong.java8action.part3.chapter10;

import java.util.Optional;

public class PersonNew {
    private Optional<CarNew> car;
    public Optional<CarNew> getCar() { return car; }

    // 使用Optional
    public String getCarInsuranceName(PersonNew person) {
        Optional<PersonNew> per = Optional.of(person);
        return per.flatMap(PersonNew::getCar)
            .flatMap(CarNew::getInsurance)
            .map(Insurance::getName)
            .orElse("Unknown");
    }
}
