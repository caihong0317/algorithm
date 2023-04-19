package com.caihong.javaVM.oom;

import java.util.ArrayList;

public class HeapOOM {
    static class OOMobj{

    }

    public static void main(String[] args) {
        ArrayList<OOMobj> list = new ArrayList<>();
        while (true){
            list.add(new OOMobj());
        }
    }
}
