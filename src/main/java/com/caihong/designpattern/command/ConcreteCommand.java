package com.caihong.designpattern.command;

public class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        preExecute();
        receiver.action();
        postExecute();
    }

    @Override
    public void undo() {
        receiver.undo();
    }

    private void preExecute() {
    }

    private void postExecute() {
    }
}
