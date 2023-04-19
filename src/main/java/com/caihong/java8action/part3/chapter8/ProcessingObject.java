package com.caihong.java8action.part3.chapter8;

public abstract class ProcessingObject<T> {
    protected ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T result = handleWork(input);
        if (successor != null) {
            return successor.handle(result);
        }
        return result;
    }

    protected abstract T handleWork(T input);
}
