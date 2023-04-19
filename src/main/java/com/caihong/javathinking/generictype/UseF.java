package com.caihong.javathinking.generictype;

public class UseF<T extends HasF> {
    private T obj;

    public UseF(T obj) {
        this.obj = obj;
    }
    public void use(){
         obj.f();
    }

    // 会返回确切类型
    public T getObj(){
        return obj;
    }

    public static void main(String[] args) {
        UseF<HasF> useF = new UseF<>(new HasF());
        System.out.println(useF.getObj().getClass().getSimpleName()); // HasF
        UseF<HasF> useF1 = new UseF<>(new SubHasF());
        System.out.println(useF1.getObj().getClass().getSimpleName()); // SubHasF
    }
}
