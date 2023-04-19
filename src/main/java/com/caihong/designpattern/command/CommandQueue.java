package com.caihong.designpattern.command;

import java.util.ArrayList;
import java.util.List;

public class CommandQueue {
    private List<Command> queue = new ArrayList<>(10);

    public void add(Command command) {
        queue.add(command);
    }

    public void remove(Command command) {
        queue.remove(command);
    }

    public void execute() {
        for (Command command : queue) {
            command.execute();
        }
    }
}
