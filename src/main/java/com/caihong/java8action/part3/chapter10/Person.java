package com.caihong.java8action.part3.chapter10;

import java.util.Optional;

public class Person {
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Optional<Car> getCarAsOptional() {
        return Optional.ofNullable(car);
    }
}
