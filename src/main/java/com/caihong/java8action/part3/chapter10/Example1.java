package com.caihong.java8action.part3.chapter10;

import java.util.Optional;

public class Example1 {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello");
        System.out.println(optional.toString());

    }

    // 未做null检查
    public String getCarInsuranceName1(Person person) {
        return person.getCar().getInsurance().getName();
    }

    // 深层质疑
    public String getCarInsuranceName2(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "Unknown";
    }

    // 过多的退出语句
    public String getCarInsuranceName(Person person) {
        if (person == null) {
            return "Unknown";
        }
        Car car = person.getCar();
        if (car == null) {
            return "Unknown";
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "Unknown";
        }
        return insurance.getName();
    }

    // 使用Optional
    public String getCarInsuranceName(PersonNew person) {
        Optional<PersonNew> per = Optional.of(person);
        return per.flatMap(PersonNew::getCar)
            .flatMap(CarNew::getInsurance)
            .map(Insurance::getName)
            .orElse("Unknown");
    }

    // 解包并不优雅
    public Optional<Insurance> nullSafeFindCheapestInsurance1(
        Optional<Person> person, Optional<Car> car) {
        if (person.isPresent() && car.isPresent()) {
            return Optional.of(findCheapestInsurance(person.get(), car.get()));
        } else {
            return Optional.empty();
        }
    }

    // 优雅
    public Optional<Insurance> nullSafeFindCheapestInsurance2(
        Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }

    private Insurance findCheapestInsurance(Person person, Car car) {
        // 查询
        return new Insurance("cheapest");
    }

    //
    public boolean getSpecificInsurance1(String name) {
        // 模拟查询
        Insurance insurance = new Insurance("renshou");
        return insurance != null && insurance.getName().equals(name);
    }

    //filter
    public void getSpecificInsurance2(String name) {
        // 模拟查询
        Insurance insurance = new Insurance("renshou");
        Optional<Insurance> optional = Optional.of(insurance);
        optional.filter(i -> name.equals(i.getName())).ifPresent(System.out::println);
    }
}