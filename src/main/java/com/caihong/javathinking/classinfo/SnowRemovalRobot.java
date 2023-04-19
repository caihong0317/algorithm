package com.caihong.javathinking.classinfo;

import java.util.Arrays;
import java.util.List;

public class SnowRemovalRobot implements Robot {
    private String name;
    private String mode;

    public SnowRemovalRobot(String name, String mode) {
        this.name = name;
        this.mode = mode;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return mode;
    }

    @Override
    public List<Operation> operations() {
        return Arrays.asList(new Operation() {
                                 @Override
                                 public String description() {
                                     return null;
                                 }

                                 @Override
                                 public void command() {

                                 }
                             },
            new Operation() {
                @Override
                public String description() {
                    return null;
                }

                @Override
                public void command() {

                }
            });
    }
}
