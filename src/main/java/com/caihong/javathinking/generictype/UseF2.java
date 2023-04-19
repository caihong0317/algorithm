package com.caihong.javathinking.generictype;

// 不够灵活
public class UseF2 {
    private HasF obj;

    public UseF2(HasF obj) {
        this.obj = obj;
    }
    public void use(){
         obj.f();
    }
}
