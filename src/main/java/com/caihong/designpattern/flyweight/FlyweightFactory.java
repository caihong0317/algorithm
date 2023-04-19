package com.caihong.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private Map<String, AbstractFlyweight> map = new HashMap();

    public AbstractFlyweight getFlyweight(String key){
        if (map.containsKey(key)) {
            return map.get(key);
        }else {
            AbstractFlyweight flyweight = new FlyweightA();
            map.put(key,flyweight);
            return flyweight;
        }
    }
}
